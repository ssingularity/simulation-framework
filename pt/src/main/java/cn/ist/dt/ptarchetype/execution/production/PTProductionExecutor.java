package cn.ist.dt.ptarchetype.execution.production;

import cn.ist.dt.ptarchetype.execution.PTService;
import cn.ist.dt.ptarchetype.models.production.PTProductionBehavior;
import cn.ist.dt.ptarchetype.models.production.PTProductionInput;
import cn.ist.dt.ptarchetype.models.production.PTProductionOutput;
import cn.ist.dt.ptarchetype.models.production.PTProductionTask;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Data
public class PTProductionExecutor extends PTWorkingLoop {
    protected PTProductionBehavior productionBehavior = new PTProductionBehavior();

    protected List<PTProductionInput> ptInputList = Collections.synchronizedList(new ArrayList<>());

    protected List<PTProductionOutput> ptOutputList = Collections.synchronizedList(new ArrayList<>());

    protected List<PTProductionTask> onGoingPTProductionTask = Collections.synchronizedList(new ArrayList<>());

    protected PTService service;

    /**
     * 完成基于切片方式的任务处理，其中任务的处理通过Sleep的方式切片模拟
     */
    @Override
    public void doTask() {
        preprocess();
        processTasks();
        postprocess();
    }

    protected void preprocess() {

    }

    protected void processTasks() {
        Iterator<PTProductionTask> it = onGoingPTProductionTask.iterator();
        while (it.hasNext()) {
            PTProductionTask ptProductionTask = it.next();
            productionBehavior.doTask(ptProductionTask, sliceTime);
            if (ptProductionTask.canFinish()) {
                ptOutputList.add(productionBehavior.doOutput(ptProductionTask));
                it.remove();
            }
        }
    }

    protected void postprocess() {

    }

    @Override
    protected void reset() {
        this.onGoingPTProductionTask.clear();
    }

    public void handleInput(PTProductionInput input) {
        this.onGoingPTProductionTask.add(new PTProductionTask(input));
    }
}
