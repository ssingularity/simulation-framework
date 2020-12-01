package cn.ist.dt.dtarchetype.communication;

import cn.ist.dt.dtarchetype.communication.messages.*;
import cn.ist.dt.dtarchetype.execution.DTService;
import cn.ist.dt.dtarchetype.models.production.DTInstruction;
import cn.ist.dt.dtarchetype.models.production.DTProductionInput;
import cn.ist.dt.dtarchetype.models.production.PTProductionInput;
import cn.ist.dt.dtarchetype.models.production.PTProductionOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DTController {
    @Autowired
    DTService dtLifeCycleService;

    @PostMapping("/")
    public void handleNeighborInput(@RequestBody DTProductionInputMsg dtProductionInput) {
        DTProductionInput input = dtProductionInput.getPayload();
    }

    @PostMapping("/")
    public void handlePTInput(@RequestBody PTProductionInputSyncMsg ptProductionInput) {
        PTProductionInput input = new PTProductionInput();
        input.setId(ptProductionInput.getInputId());
    }

    @PostMapping("/")
    public void handlePTOutput(@RequestBody PTProductionOutputSyncMsg ptProductionOutput) {
        PTProductionOutput output = new PTProductionOutput();
        output.setId(ptProductionOutput.getOutputId());
    }

    @PostMapping("/")
    public void handleAgentInstruction(@RequestBody DTInstructionMsg dtInstruction){
        DTInstruction instruction = dtInstruction.getInstruction();
    }

    @PostMapping("/")
    public void handleNeighborUpdate(@RequestBody NeighborUpdateMsg neighborUpdateMsg){

    }

    @PostMapping("/")
    public void handlePTStateUpdate(@RequestBody PTStateUpdateMsg ptStateUpdateMsg){

    }
}
