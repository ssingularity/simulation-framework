package cn.ist.dt.dtarchetype.models.interaction;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Neighbor {
    protected String id;
    protected Map<Endpoint, String> endpoints;

    public Neighbor(String id) {
        this.id = id;
        Map<Endpoint, String> endpoints = new HashMap<>();
    }

    public enum Endpoint{
        UPDATE, INPUT;
    }
}
