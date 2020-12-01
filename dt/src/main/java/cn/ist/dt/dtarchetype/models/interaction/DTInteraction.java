package cn.ist.dt.dtarchetype.models.interaction;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class DTInteraction {
    protected String id;
    protected Set<Neighbor> inputNeighbors = new HashSet<>();
    protected Set<Neighbor> outputNeighbors = new HashSet<>();
    protected Set<Agent> agents = new HashSet<>();
    protected PhysicalTwin pt;
    // maps of port indices and ports
    protected Map<Integer, DTPort> ports = new HashMap<>();

}
