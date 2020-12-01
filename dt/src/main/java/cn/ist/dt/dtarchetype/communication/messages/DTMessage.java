package cn.ist.dt.dtarchetype.communication.messages;

import lombok.Data;

@Data
public abstract class DTMessage {
    protected String msgName;

    protected String sender;

    protected String recipient;

    protected long timestamp;
}
