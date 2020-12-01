package cn.ist.dt.dtarchetype.communication.messages;

import cn.ist.dt.dtarchetype.models.production.DTInstruction;
import lombok.Data;

@Data
public class PTInstructionMsg extends DTMessage{
    protected DTInstruction instruction;
}
