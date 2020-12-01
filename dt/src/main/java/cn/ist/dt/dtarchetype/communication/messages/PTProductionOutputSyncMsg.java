package cn.ist.dt.dtarchetype.communication.messages;

import lombok.Data;

@Data
public class PTProductionOutputSyncMsg extends DTMessage {
    protected String outputId;;
}
