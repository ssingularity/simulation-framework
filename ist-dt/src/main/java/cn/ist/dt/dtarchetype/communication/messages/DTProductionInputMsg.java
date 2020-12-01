package cn.ist.dt.dtarchetype.communication.messages;

import cn.ist.dt.dtarchetype.models.production.DTProductionInput;
import lombok.Data;

@Data
public class DTProductionInputMsg extends DTMessage {
    protected DTProductionInput payload;
}
