package cn.ist.dt.dtarchetype.communication;


import cn.ist.dt.dtarchetype.common.HttpCallUtils;
import cn.ist.dt.dtarchetype.common.JSONUtils;
import cn.ist.dt.dtarchetype.communication.messages.DTProductionOutputMsg;
import cn.ist.dt.dtarchetype.communication.messages.NeighborUpdateMsg;
import cn.ist.dt.dtarchetype.models.interaction.DTPort;
import cn.ist.dt.dtarchetype.models.interaction.Neighbor;

import java.io.IOException;
import java.util.Set;

public class NeighborUpdater {
    public static void broadcast(Set<Neighbor> neighbors, NeighborUpdateMsg update){
        for(Neighbor neighbor : neighbors){
            sendUpdate(neighbor, update);
        }
    }

    public static void sendUpdate(Neighbor neighbor, NeighborUpdateMsg update){
        String request = JSONUtils.writeValueAsString(update);
        try {
            HttpCallUtils.call(neighbor.getEndpoints().get(Neighbor.Endpoint.UPDATE), request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendProductionOutput(DTPort port, DTProductionOutputMsg output){
        String request = JSONUtils.writeValueAsString(output);
        try {
            HttpCallUtils.call(port.getDestination(), request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
