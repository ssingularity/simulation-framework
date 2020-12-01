package cn.ist.dt.dtarchetype.execution.production;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public abstract class DTWorkingLoop implements Runnable{
    protected long sliceTime;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                doTask();
                Thread.sleep(sliceTime);
            } catch (InterruptedException e) {
                log.info("Exit From WorkingLoop");
                break;
            } catch (Exception e) {
                log.error("", e);
                log.warn("Reset WorkingLoop");
                reset();
            }
        }
    }

    public abstract void doTask();

    protected abstract void reset();
}
