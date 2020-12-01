package cn.ist.agent.communication;

import cn.ist.agent.common.HttpCallUtils;
import cn.ist.agent.common.JSONUtils;
import cn.ist.agent.communication.messages.DTInstructionMsg;

import java.io.IOException;

public class DTUpdater {
    public void sendInstruction(String dtEndpoint, DTInstructionMsg instruction){
        String request = JSONUtils.writeValueAsString(instruction);
        try {
            HttpCallUtils.call(dtEndpoint, request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
