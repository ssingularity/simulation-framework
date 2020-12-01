package cn.ist.dt.dtarchetype.models.production;

import lombok.Setter;

public class DTProductionBehavior {
    @Setter
    protected Long taskTime;

    public void doTask(DTProductionTask dtProductionTask, Long sliceTime) {
        if (dtProductionTask.isWaiting()) {
            preStartTask(dtProductionTask);
            dtProductionTask.runWith(taskTime);
        }
        dtProductionTask.elapse(sliceTime);
    }

    /**
     * 设置根据各自实现完成内部状态的变更
     * @param dtProductionTask 任务
     */
    protected void preStartTask(DTProductionTask dtProductionTask){

    }

    /**
     * 处理Agent的指令
     * @param DTInstruction Agent发来的指令
     */
    protected void handleInstruction(DTInstruction DTInstruction){

    }

    /**
     * 根据各自状态完成对应的输出
     * @param dtProductionTask 加工对象
     * @return DTProductionOutput 完成的产物
     */
    public DTProductionOutput doOutput(DTProductionTask dtProductionTask){
        return null;
    }
}
