package cn.ist.dt.ptarchetype.communication.messages;

import cn.ist.dt.ptarchetype.models.production.PTInstruction;
import lombok.Data;

@Data
public class PTInstructionMsg extends PTMessage {
    protected PTInstruction instruction;
}
