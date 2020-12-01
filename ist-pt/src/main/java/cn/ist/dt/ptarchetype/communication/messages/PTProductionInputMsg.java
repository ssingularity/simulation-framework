package cn.ist.dt.ptarchetype.communication.messages;

import cn.ist.dt.ptarchetype.models.production.PTProductionInput;
import lombok.Data;

@Data
public class PTProductionInputMsg extends PTMessage {
    protected PTProductionInput payload;
}
