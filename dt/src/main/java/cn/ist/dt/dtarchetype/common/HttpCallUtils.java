package cn.ist.dt.dtarchetype.common;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

@Slf4j
public class HttpCallUtils {

	public static void call(String apiEndPoint, String body, String method) throws IOException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = null;

		try {
			if (method.equals("POST")) {
				request = HttpRequest.newBuilder().uri(URI.create(apiEndPoint)).timeout(Duration.ofMinutes(20))
						.header("Content-Type", "application/json; charset=UTF-8")
						.POST(BodyPublishers.ofString(body)).build();
			} else if (method.equals("GET")) {
				request = HttpRequest.newBuilder().uri(URI.create(apiEndPoint)).timeout(Duration.ofMinutes(20)).GET()
						.build();
			}

			client.sendAsync(request, BodyHandlers.ofString()).thenApply(response -> {
				System.out.println(response.statusCode());
				return response;
			}).thenApply(HttpResponse::body).exceptionally(e -> {
				log.error(e.getMessage(), e);
				log.error("Error from URL: " + apiEndPoint);
				log.error("request body: " + body);
				return "";
			}).thenAccept(System.out::println);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
		}
	}

	public class Method{
		public static final String GET = "GET";
		public static final String POST = "POST";
	}
}
