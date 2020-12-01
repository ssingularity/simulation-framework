package cn.ist.dt.dtarchetype.models.production;

import lombok.Data;

@Data
public class DTProductionTask {
    final DTProductionInput productionInput;

    protected Long remainingTime;

    protected TaskState taskState;

    public DTProductionTask(DTProductionInput productionInput) {
        this.remainingTime = -1L;
        this.taskState = TaskState.Waiting;
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
        return this.taskState == TaskState.Running && this.remainingTime <= 0L;
    }

    public boolean isWaiting() {
        return this.taskState == TaskState.Waiting;
    }

    public enum  TaskState {
        Waiting, Running, Finished
    }
}
