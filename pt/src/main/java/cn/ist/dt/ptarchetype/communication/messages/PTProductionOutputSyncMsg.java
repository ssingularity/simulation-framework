package cn.ist.dt.ptarchetype.communication.messages;

import lombok.Data;

@Data
public class PTProductionOutputSyncMsg extends PTMessage {
    protected String outputId;
}
