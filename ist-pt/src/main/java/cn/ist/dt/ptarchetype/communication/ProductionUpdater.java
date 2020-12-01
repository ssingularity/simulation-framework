package cn.ist.dt.ptarchetype.communication;


import cn.ist.dt.ptarchetype.common.HttpCallUtils;
import cn.ist.dt.ptarchetype.common.JSONUtils;
import cn.ist.dt.ptarchetype.communication.messages.PTProductionOutputMsg;
import cn.ist.dt.ptarchetype.models.interaction.PTPort;

import java.io.IOException;

public class ProductionUpdater {
    public static void sendProductionOutput(PTPort export, PTProductionOutputMsg output){
        String request = JSONUtils.writeValueAsString(output);
        try {
            HttpCallUtils.call(export.getDestination(), request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
