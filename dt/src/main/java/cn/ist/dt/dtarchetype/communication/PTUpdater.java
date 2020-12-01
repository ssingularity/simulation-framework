package cn.ist.dt.dtarchetype.communication;


import cn.ist.dt.dtarchetype.common.HttpCallUtils;
import cn.ist.dt.dtarchetype.common.JSONUtils;
import cn.ist.dt.dtarchetype.communication.messages.PTInstructionMsg;
import cn.ist.dt.dtarchetype.models.interaction.PhysicalTwin;

import java.io.IOException;

public class PTUpdater {
    public static void sendInstruction(PhysicalTwin pt, PTInstructionMsg instruction) {
        String request = JSONUtils.writeValueAsString(instruction);
        try {
            HttpCallUtils.call(pt.getEndpoints().get(PhysicalTwin.Endpoint.OPERATE), request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
