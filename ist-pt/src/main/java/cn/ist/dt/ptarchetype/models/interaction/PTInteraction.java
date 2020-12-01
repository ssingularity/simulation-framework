package cn.ist.dt.ptarchetype.models.interaction;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PTInteraction {
    protected String id;

    // maps of port indices and ports
    protected Map<Integer, PTPort> ports = new HashMap<>();

    protected DigitalTwin dt;

}
