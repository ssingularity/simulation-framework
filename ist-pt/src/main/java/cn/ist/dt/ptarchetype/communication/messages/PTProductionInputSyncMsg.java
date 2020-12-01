package cn.ist.dt.ptarchetype.communication.messages;

import lombok.Data;

@Data
public class PTProductionInputSyncMsg extends PTMessage {
    protected String inputId;
}
