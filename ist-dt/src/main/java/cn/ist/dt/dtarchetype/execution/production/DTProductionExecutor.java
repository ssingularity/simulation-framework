package cn.ist.dt.dtarchetype.execution.production;

import cn.ist.dt.dtarchetype.execution.DTService;
import cn.ist.dt.dtarchetype.models.production.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Data
public class DTProductionExecutor extends DTWorkingLoop {

    protected DTProductionBehavior productionBehavior = new DTProductionBehavior();

    protected List<PTProductionInput> ptInputList = Collections.synchronizedList(new ArrayList<>());

    protected List<PTProductionOutput> ptOutputList = Collections.synchronizedList(new ArrayList<>());

    protected List<DTProductionInput> dtProductionInputList = Collections.synchronizedList(new ArrayList<>());

    protected List<DTProductionOutput> dtProductionOutputList = Collections.synchronizedList(new ArrayList<>());

    protected List<DTProductionTask> onGoingDTProductionTask = Collections.synchronizedList(new ArrayList<>());

    protected List<DTProductionInput> finishedDTProductionInputList = Collections.synchronizedList(new ArrayList<>());

//    protected List<Instruction> instructionList = Collections.synchronizedList(new ArrayList<>());

    protected DTService service;

    //TODO 模拟故障

    /**
     * 完成基于切片方式的任务处理
     *
     * 大致流程如下：
     * 1. 检查因果关系以及是否存在可以开始处理的Task
     * 2. 通过Sleep的方式切片模拟完成业务场景
     * 3. 处理输出
     * 4. 处理Agent发来的指令
     */
    public void doTask() {
        preprocess();
        processTasks();
        postprocess();
    }

    protected void reset() {
        this.ptInputList.clear();
        this.ptOutputList.clear();
        this.dtProductionInputList.clear();
        this.onGoingDTProductionTask.clear();
        this.finishedDTProductionInputList.clear();
    }

    protected void preprocess() {
        // e.g., causality check
    }

    protected void processTasks() {
        Iterator<DTProductionTask> it = onGoingDTProductionTask.iterator();
        while (it.hasNext()) {
            DTProductionTask task = it.next();
            if (task.canFinish()) {
                it.remove();
                finishedDTProductionInputList.add(task.getProductionInput());
                dtProductionOutputList.add(productionBehavior.doOutput(task));
            }
            else {
                productionBehavior.doTask(task, sliceTime);
            }
        }
    }

    protected void postprocess() {
        // e.g., production output, neighbor/agent state update, etc.
    }
}
