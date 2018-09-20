package com.nino.model;

public class ScheduleBean {

    private long initialDelay;
    private long period;
    private TimeValid timeValid;
    private int DEFAULT_RETRY_TIMES = 3;
    private int retryTimes = DEFAULT_RETRY_TIMES;

    public ScheduleBean(long initialDelay, long period, int retryTimes, TimeValid timeValid) {
        this.initialDelay = initialDelay;
        this.period = period;
        this.retryTimes = retryTimes;
        this.timeValid = timeValid;
    }

    public ScheduleBean(long initialDelay, long period, TimeValid timeValid) {
        this.initialDelay = initialDelay;
        this.period = period;
        this.timeValid = timeValid;
    }

    public ScheduleBean(TimeValid timeValid) {
        this.timeValid = timeValid;
    }

    public TimeValid getTimeValid() {
        return timeValid;
    }

    public void setTimeValid(TimeValid timeValid) {
        this.timeValid = timeValid;
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

    public enum TimeValid {
        VALID, INVALID
    }
}
