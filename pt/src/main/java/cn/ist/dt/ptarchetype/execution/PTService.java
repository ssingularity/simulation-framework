package cn.ist.dt.ptarchetype.execution;

import cn.ist.dt.ptarchetype.common.DefaultThreadFactory;
import cn.ist.dt.ptarchetype.common.ServiceBase;
import cn.ist.dt.ptarchetype.communication.DTUpdater;
import cn.ist.dt.ptarchetype.communication.messages.PTProductionInputSyncMsg;
import cn.ist.dt.ptarchetype.communication.messages.PTProductionOutputSyncMsg;
import cn.ist.dt.ptarchetype.execution.production.PTProductionExecutor;
import cn.ist.dt.ptarchetype.models.interaction.PTInteraction;
import cn.ist.dt.ptarchetype.models.production.PTInstruction;
import cn.ist.dt.ptarchetype.models.production.PTProductionInput;
import cn.ist.dt.ptarchetype.models.production.PTProductionOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class PTService extends ServiceBase {
    protected ExecutorService threadPool = Executors.newCachedThreadPool(new DefaultThreadFactory("PT WorkingLoop" +
            " Thread Manager"));
    protected PTProductionExecutor productionExecutor;
    protected PTInteraction interactionModel;

    @PostConstruct
    public void initialize() {
        productionExecutor = new PTProductionExecutor();
        productionExecutor.setSliceTime(env.getProperty("production.slicetime", Long.class));
        productionExecutor.setService(this);
        productionExecutor.getProductionBehavior().setTaskTime(env.getProperty("production.tasktime", Long.class));
        threadPool.submit(productionExecutor);
    }

    @PreDestroy
    public void terminateProduction() {
        threadPool.shutdown();
    }

    public void receivePTProductionInput(PTProductionInput input) {

        log.info("Production input: " + input);

        productionExecutor.getPtInputList().add(input);
    }

    public void receiveProductionInstruction(PTInstruction instruction) {

    }

    public void syncInput(PTProductionInput input){
        PTProductionInputSyncMsg msg = new PTProductionInputSyncMsg();
        msg.setInputId(input.getId());
        msg.setMsgName("PTProductionInputSyncMsg");
        msg.setSender(interactionModel.getId());
        msg.setTimestamp(System.currentTimeMillis());
        DTUpdater.syncProductionInput(interactionModel.getDt(), msg);
    }

    public void syncOutput(PTProductionOutput output){
        PTProductionOutputSyncMsg msg = new PTProductionOutputSyncMsg();
        msg.setOutputId(output.getId());
        msg.setMsgName("PTProductionOuputSyncMsg");
        msg.setSender(interactionModel.getId());
        msg.setTimestamp(System.currentTimeMillis());
        DTUpdater.syncProductionOutput(interactionModel.getDt(), msg);
    }
}
