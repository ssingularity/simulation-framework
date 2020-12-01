package cn.ist.dt.ptarchetype.communication;

import cn.ist.dt.ptarchetype.communication.messages.PTInstructionMsg;
import cn.ist.dt.ptarchetype.communication.messages.PTProductionInputMsg;
import cn.ist.dt.ptarchetype.models.production.PTInstruction;
import cn.ist.dt.ptarchetype.models.production.PTProductionInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PTController {
    @PostMapping("/")
    public void handleInstruction(@RequestBody PTInstructionMsg ptInstruction){
        PTInstruction instruction = ptInstruction.getInstruction();
    }

    @PostMapping("/")
    public void handleProductionInput(@RequestBody PTProductionInputMsg productionInput){
        PTProductionInput input = productionInput.getPayload();
    }
}
