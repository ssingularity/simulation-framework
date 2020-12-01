package cn.ist.dt.dtarchetype.execution;

import cn.ist.dt.dtarchetype.common.DefaultThreadFactory;
import cn.ist.dt.dtarchetype.common.ServiceBase;
import cn.ist.dt.dtarchetype.execution.production.DTProductionExecutor;
import cn.ist.dt.dtarchetype.models.interaction.DTInteraction;
import cn.ist.dt.dtarchetype.models.production.DTInstruction;
import cn.ist.dt.dtarchetype.models.production.DTProductionInput;
import cn.ist.dt.dtarchetype.models.production.PTProductionInput;
import cn.ist.dt.dtarchetype.models.production.PTProductionOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class DTService extends ServiceBase {
    protected ExecutorService threadPool = Executors.newCachedThreadPool(new DefaultThreadFactory("DT WorkingLoop"
            + " Thread Manager"));
    protected DTProductionExecutor productionExecutor;
    protected DTInteraction interactionModel;

    @PostConstruct
    public void initialize() {
        productionExecutor = new DTProductionExecutor();
        productionExecutor.setSliceTime(env.getProperty("production.slicetime", Long.class));
        productionExecutor.setService(this);
        productionExecutor.getProductionBehavior().setTaskTime(env.getProperty("production.tasktime", Long.class));
        threadPool.submit(productionExecutor);
    }

    @PreDestroy
    public void terminateProduction() {
        threadPool.shutdown();
    }

    public void receiveDTProductionInput(DTProductionInput input) {

        log.info("Production input from DT: " + input);

        productionExecutor.getDtProductionInputList().add(input);
    }

    public void receivePTProductionInput(PTProductionInput input) {

        log.info("Production input from PT: " + input);

        productionExecutor.getPtInputList().add(input);
    }

    public void receivePTProductionOutput(PTProductionOutput output) {

        log.info("Production output from PT: " + output);

        productionExecutor.getPtOutputList().add(output);
    }

    public void receiveProductionInstruction(DTInstruction instruction) {

        log.info("Instruction output from agent: " + instruction);
    }
}
