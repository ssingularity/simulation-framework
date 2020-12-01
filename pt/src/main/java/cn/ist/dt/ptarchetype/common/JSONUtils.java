package cn.ist.dt.ptarchetype.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
    protected static ObjectMapper objectMapper = new ObjectMapper();

    public static String writeValueAsString(Object source) {
        try {
            return objectMapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(source + " can't convert to string");
        }
    }
}
