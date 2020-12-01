package cn.ist.dt.ptarchetype.models.production;

import lombok.Data;


@Data
public class PTProductionTask {
    protected Long remainingTime;

    protected TaskState taskState;

    protected PTProductionInput productionInput;


    public PTProductionTask(PTProductionInput productionInput) {
        this.remainingTime = -1L;
        this.taskState = PTProductionTask.TaskState.Waiting;
        this.productionInput = productionInput;
    }

    public void elapse(Long time) {
        this.remainingTime -= time;
    }

    public void runWith(Long remainingTime) {
        this.remainingTime = remainingTime;
        this.taskState = TaskState.Running;
    }

    public boolean canFinish() {
        return this.taskState == PTProductionTask.TaskState.Running && this.remainingTime <= 0L;
    }

    public boolean isWaiting() {
        return this.taskState == PTProductionTask.TaskState.Waiting;
    }

    public enum  TaskState {
        Waiting, Running, Finished
    }
}
