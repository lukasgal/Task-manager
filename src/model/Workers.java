package model;

import Comparators.CompareByWorkersPriority;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Lukáš Gál
 */
public class Workers {

    private ArrayList<Worker> workers = new ArrayList<>();
    public static final int MAX_DAILY_WORKING_HOURS = 8;

    public Workers() {
    }

    public void addWorker(Worker w) throws Exception {
        if (!workers.contains(w)) {
            workers.add(w);
        } else {
            throw new Exception("The worker already is in the worker list.");
        }
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public boolean areFinished() {
        boolean f = true;
        for (Worker w : getWorkers()) {
            f &= w.isFinished();

        }
        return f;
    }

    public Worker chooseWorkerWithMinHours() {
        Worker choosed = workers.get(0);

        for (int i = 1; i < workers.size(); i++) {
            Worker currentWorker = workers.get(i);
            if (currentWorker.getHoursWorked() < Workers.MAX_DAILY_WORKING_HOURS && currentWorker.getHoursWorked() < choosed.getHoursWorked()) {
                choosed = currentWorker;
            }
        }
        return choosed;

    }

    public void sortByPriority() {
        Collections.sort(workers, new CompareByWorkersPriority());
    }

    public Worker getLessBussyWorker() {
        Worker minW = getWorkers().get(0);
        
        for (int i = 1; i < getWorkers().size(); i++) {
            Worker w = getWorkers().get(i);
            if (minW.getTotalHours()> w.getTotalHours()) {
                minW = w;
            }
        }
        return minW;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s %-5s %-6s\n", "pracovnik", "odprac", "celkem"));
        for (Worker w : getWorkers()) {
            sb.append(w);
        }
        return sb.toString();
    }

    int size() {
        return getWorkers().size();
    }

}
