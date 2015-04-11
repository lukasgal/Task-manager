package Entity;

/**
 *
 * @author Lukáš Gál
 */
public class TaskSheduler {

    private Tasks tasks;
    private Workers workers;

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

    public void plan() {
        int i = 1;

        while (tasks.chooseTask() != null) {
            WorkingDay wd = newDay(i);

            Task lastSolvedTask = null;
            while (!workers.areFinished() && tasks.chooseTask() != null) {

                for (Worker w : workers.getWorkers()) {
                    
                    while (!w.isFinished()) {
                        Task t = tasks.chooseTask();
                        if(t==null)
                            break;
                        int wh = w.canWorkYet();
                        int status = t.getStatusTime();
                        if (status > 0 && wh > 0) {
                            int ready = (status > wh) ? wh : status;
                            w.setHoursWorked(ready);
                            t.setReady(ready);
                            
                                SolvingTask st = new SolvingTask(w, t, ready);
                                lastSolvedTask = t;
                                wd.addSolvingTask(st);

                                //output
                                System.out.print(st);
                            
                        }
                    }
                }

            }//while workers finished
            i++;
            System.out.println("----------------------\n");
        }//while tasks

    }

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
