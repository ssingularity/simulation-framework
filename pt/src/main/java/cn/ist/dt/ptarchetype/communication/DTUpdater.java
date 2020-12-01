package cn.ist.dt.ptarchetype.communication;


import cn.ist.dt.ptarchetype.common.HttpCallUtils;
import cn.ist.dt.ptarchetype.common.JSONUtils;
import cn.ist.dt.ptarchetype.communication.messages.PTProductionInputSyncMsg;
import cn.ist.dt.ptarchetype.communication.messages.PTProductionOutputSyncMsg;
import cn.ist.dt.ptarchetype.communication.messages.PTStateUpdateMsg;
import cn.ist.dt.ptarchetype.models.interaction.DigitalTwin;

import java.io.IOException;

public class DTUpdater {
    public static void syncProductionInput(DigitalTwin dt, PTProductionInputSyncMsg inputSync){
        String request = JSONUtils.writeValueAsString(inputSync);
        try {
            HttpCallUtils.call(dt.getEndpoints().get(DigitalTwin.Endpoint.INPUTSync), request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void syncProductionOutput(DigitalTwin dt, PTProductionOutputSyncMsg outputSync){
        String request = JSONUtils.writeValueAsString(outputSync);
        try {
            HttpCallUtils.call(dt.getEndpoints().get(DigitalTwin.Endpoint.OUTPUTSync), request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void syncState(DigitalTwin dt, PTStateUpdateMsg stateSync){
        String request = JSONUtils.writeValueAsString(stateSync);
        try {
            HttpCallUtils.call(dt.getEndpoints().get(DigitalTwin.Endpoint.STATESync), request, HttpCallUtils.Method.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
