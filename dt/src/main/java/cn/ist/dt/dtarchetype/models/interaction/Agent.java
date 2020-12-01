package cn.ist.dt.dtarchetype.models.interaction;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Agent {
    protected String id;
    protected Map<Endpoint, String> endpoints;

    public Agent(String id) {
        this.id = id;
        endpoints = new HashMap<>();
    }

    public enum Endpoint{
        UPDATE;
    }
}
