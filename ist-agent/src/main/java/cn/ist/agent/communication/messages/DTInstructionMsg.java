package cn.ist.agent.communication.messages;


import cn.ist.agent.logic.DTInstruction;
import lombok.Data;

@Data
public class DTInstructionMsg extends AgentMessage {
    protected DTInstruction instruction;
}
