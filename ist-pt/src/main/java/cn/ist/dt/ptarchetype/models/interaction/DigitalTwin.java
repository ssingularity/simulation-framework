package cn.ist.dt.ptarchetype.models.interaction;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DigitalTwin {
    protected String id;

    protected Map<Endpoint, String> endpoints;

    public DigitalTwin(String id) {
        this.id = id;
        endpoints = new HashMap<>();
    }

    public enum Endpoint{
        INPUTSync, OUTPUTSync, STATESync;
    }
}
