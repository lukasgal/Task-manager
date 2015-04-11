package Entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lukáš Gál
 */
public class TaskSheduler {

    private Tasks tasks;
    private Workers workers;
    private final HashMap<Integer, WorkingDay> workingDays = new HashMap<>();

    public TaskSheduler(Tasks tasks, Workers workers) {
        this.tasks = tasks;
        this.workers = workers;
    }

    public WorkingDay newDay(int i) {
        WorkingDay wd = new WorkingDay(i);
        System.out.println(wd);

        //empty workers hours
        for (Worker w : this.workers.getWorkers()) {
            w.emptyHours();
        }
        return wd;
    }

    public void addWorkingDay(Integer id, WorkingDay wd) {
        workingDays.put(id, wd);
    }

    public void plan() {
        int i = 1;
        Task chTask;
        WorkingDay wd = newDay(i);
        addWorkingDay(i, wd);
        while ((chTask = tasks.chooseTask()) != null) {

            WorkingDay yesterday = null;
            if (i > 1) {
                yesterday = workingDays.get(i - 1);
                if (yesterday.getUnfinishedTasks().size() > 0) {
                    int g = 0;
                    for (SolvingTask st1 : yesterday.getUnfinishedTasks()) {
                        System.out.println("unfinished");
                        System.out.println(st1);
                        if (chTask == st1.getTask()) {
                            st1.getWorker().setPriority(g++);
                            break;
                        }
                    }
                }
            }
            workers.sortByPriority();

            if (workers.areFinished()) {
                wd = newDay(i);
                addWorkingDay(i, wd);
                
            }

            while (!workers.areFinished() && !chTask.isFinished()) {

                //for (Worker w : workers.getWorkers()) {
                Worker w = workers.getLessBussyWorker();

                int wh = w.canWorkYet();
                int status = chTask.getStatusTime();
                if (status > 0 && wh > 0) {
                    int ready = (status > wh) ? wh : status;
                    w.setHoursWorked(ready);
                    chTask.setReady(ready);

                    SolvingTask st = new SolvingTask(w, chTask, ready);

                    wd.addSolvingTask(st);

                    //output
                    System.out.print(st);

                    //}
                }
            }
            if(workers.areFinished())
                i++;
        }//while workers finished

        System.out.println("LessBussyWorker is ");
        System.out.println(workers.getLessBussyWorker());
        System.out.println("----------------------\n");
    }//while tasks

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Workers getWorkers() {
        return workers;
    }

    public void setWorkers(Workers workers) {
        this.workers = workers;
    }

}
