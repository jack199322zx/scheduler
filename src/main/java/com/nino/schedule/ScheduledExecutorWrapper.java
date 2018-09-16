package com.nino.schedule;

import com.nino.model.ScheduleBean;

import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorWrapper {

    private ScheduledThreadPoolExecutor executor;
    private ScheduleBean bean;

    public ScheduledExecutorWrapper(ScheduledThreadPoolExecutor executor, ScheduleBean bean) {
        this.executor = executor;
        this.bean = bean;
    }

    public void notifyWhenSubmit(Queue<Runnable> runnables) {
        if (executor != null) {
            runnables.forEach(r -> executor.schedule(r, 0, TimeUnit.SECONDS));
        }
    }
}
