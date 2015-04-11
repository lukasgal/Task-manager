
package Entity;

public class SolvingTask {

    Worker worker;
    Task task;
    Integer time;

    public SolvingTask(Worker worker, Task task, Integer time) {
        this.worker = worker;
        this.task = task;
        this.time = time;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %5d\t\t %-10s %5d %5d %5d\n", worker.getName(),worker.getHoursWorked(), task.getName(),task.getTime(), task.getStatusTime(), time));
        return sb.toString();
    }

}
