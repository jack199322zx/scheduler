package com.nino.model;

public class ScheduleBean {

    private long initialDelay;
    private long period;
    private int retryTimes;

    public ScheduleBean(long initialDelay, long period, int retryTimes) {
        this.initialDelay = initialDelay;
        this.period = period;
        this.retryTimes = retryTimes;
    }

    public long getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }
}
