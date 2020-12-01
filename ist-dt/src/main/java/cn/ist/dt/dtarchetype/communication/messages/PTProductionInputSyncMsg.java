package cn.ist.dt.dtarchetype.communication.messages;

import lombok.Data;

@Data
public class PTProductionInputSyncMsg extends DTMessage {
    protected String inputId;
}
