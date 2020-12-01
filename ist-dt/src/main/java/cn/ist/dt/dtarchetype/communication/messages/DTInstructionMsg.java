package cn.ist.dt.dtarchetype.communication.messages;

import cn.ist.dt.dtarchetype.models.production.DTInstruction;
import lombok.Data;

@Data
public class DTInstructionMsg extends DTMessage{
    protected DTInstruction instruction;
}
