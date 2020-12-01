package cn.ist.agent.communication.messages;

import lombok.Data;

@Data
public class DTProductionUpdateMsg extends AgentMessage {
    protected int load;
}
