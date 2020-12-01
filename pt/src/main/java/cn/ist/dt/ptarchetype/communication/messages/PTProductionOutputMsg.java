package cn.ist.dt.ptarchetype.communication.messages;

import cn.ist.dt.ptarchetype.models.production.PTProductionOutput;
import lombok.Data;

@Data
public class PTProductionOutputMsg extends PTMessage{
    protected PTProductionOutput payload;
}
