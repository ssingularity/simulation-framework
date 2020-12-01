package cn.ist.agent.communication.messages;

import lombok.Data;

@Data
public abstract class AgentMessage {
    protected String msgName;
    protected String sender;
    protected String recipient;
    protected long timestamp;
}
