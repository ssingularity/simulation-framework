package cn.ist.dt.dtarchetype.communication;


import cn.ist.dt.dtarchetype.common.HttpCallUtils;
import cn.ist.dt.dtarchetype.common.JSONUtils;
import cn.ist.dt.dtarchetype.communication.messages.DTProductionUpdateMsg;
import cn.ist.dt.dtarchetype.models.interaction.Agent;

import java.io.IOException;
import java.util.List;

public class AgentUpdater {

    public static void broadcast(List<Agent> agents, DTProductionUpdateMsg update){
        for(Agent agent : agents){
            String request = JSONUtils.writeValueAsString(update);
            try {
                HttpCallUtils.call(agent.getEndpoints().get(Agent.Endpoint.UPDATE), request, HttpCallUtils.Method.POST);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
