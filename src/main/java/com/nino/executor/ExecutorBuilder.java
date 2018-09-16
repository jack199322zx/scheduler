package com.nino.executor;

import com.nino.factory.InterpreterFactory;
import com.nino.interpreter.Interpreter;
import com.nino.interpreter.InterpreterType;
import com.nino.model.ScheduleBean;
import com.nino.schedule.ScheduledExecutorWrapper;
import org.joda.time.DateTime;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ExecutorBuilder {

    private ScheduledExecutorWrapper wrapper;
    private Interpreter interpreter;

    private Queue<Runnable> runnableList = new LinkedBlockingQueue<>();

    private ExecutorBuilder(Object o) {
        this.interpreter = InterpreterFactory.create(o);
        ScheduleBean scheduleBean = this.interpreter.interpret(o);
        this.wrapper = new ScheduledExecutorWrapper((ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(50), scheduleBean);
    }

    public static ExecutorBuilder create(DateTime origin) {
        return new ExecutorBuilder(origin);
    }

    public void submit() {
        if (this.runnableList.isEmpty()) return;
        wrapper.notifyWhenSubmit(runnableList);
    }

    public void submit(Runnable runnable) {
        this.runnableList.offer(runnable);
        wrapper.notifyWhenSubmit(runnableList);
    }

    public void submit(Queue<Runnable> runnable) {
        this.runnableList = runnable;
        wrapper.notifyWhenSubmit(runnableList);
    }

    public void add(Runnable runnable) {
        runnableList.offer(runnable);
    }

    public Runnable remove() {
        return runnableList.poll();
    }

    public Runnable get(int index) {
        if (index < 0 || index >= runnableList.size()) throw new IndexOutOfBoundsException("index should not be negative number");
        if (index == 0) return runnableList.peek();
        Iterator<Runnable> it = runnableList.iterator();
        Runnable runnable = it.next();
        for (; it.hasNext() && --index > 0;) {
            runnable = it.next();
        }
        return runnable;
    }

    public Queue<Runnable> getRunnableList() {
        return runnableList;
    }

    public void setRunnableList(Queue<Runnable> runnableList) {
        checkRunnableListRange(runnableList);
        this.runnableList = runnableList;
    }

    private void checkRunnableListRange(Queue<Runnable> runnableList) {
        if (runnableList == null) throw new IllegalStateException("runnableList should not be null");
    }
}
