package cn.ist.dt.ptarchetype.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {
    private String basicName;

    private AtomicInteger threadNumber;

    public DefaultThreadFactory(String basicName){
        this.threadNumber = new AtomicInteger(1);
        this.basicName = basicName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(basicName + "-" + threadNumber.getAndIncrement());
        return thread;
    }
}
