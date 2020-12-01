package cn.ist.dt.dtarchetype.communication.messages;

import cn.ist.dt.dtarchetype.models.production.DTProductionOutput;
import lombok.Data;

@Data
public class DTProductionOutputMsg extends DTMessage {
    protected DTProductionOutput payload;
}
