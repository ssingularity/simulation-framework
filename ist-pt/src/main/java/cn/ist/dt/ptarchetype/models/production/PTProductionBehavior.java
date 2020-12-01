package cn.ist.dt.ptarchetype.models.production;

import lombok.Setter;

public class PTProductionBehavior {
    @Setter
    protected Long taskTime;

    public void doTask(PTProductionTask ptProductionTask, Long sliceTime) {
        if (ptProductionTask.isWaiting()) {
            preStartTask(ptProductionTask);
            ptProductionTask.runWith(this.taskTime);
        }
        ptProductionTask.elapse(sliceTime);
    }
    /**
     * 设置根据各自实现完成内部状态的变更
     * @param ptProductionTask 任务
     */
    protected void preStartTask(PTProductionTask ptProductionTask) {

    }

    /**
     * 根据各自状态完成对应的输出
     * @param ptProductionTask 加工对象
     * @return PTProductionOutput 完成的产物
     */
    public PTProductionOutput doOutput(PTProductionTask ptProductionTask){
        return null;
    }
}
