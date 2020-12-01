package cn.ist.dt.ptarchetype.communication.messages;

import lombok.Data;

@Data
public abstract class PTMessage {
    protected String msgName;

    protected String sender;

    protected String recipient;

    protected long timestamp;
}
