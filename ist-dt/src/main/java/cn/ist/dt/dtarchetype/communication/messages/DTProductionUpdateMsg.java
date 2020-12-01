package cn.ist.dt.dtarchetype.communication.messages;

import lombok.Data;

@Data
public class DTProductionUpdateMsg extends DTMessage {
    protected int load;
}
