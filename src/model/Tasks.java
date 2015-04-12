package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lukáš Gál
 */
public class Tasks  implements Serializable{

    private ArrayList<Task> tasks = new ArrayList<>();

    private static int lastId = 1;

    public void addTask(Task t) {
        t.setIdTask(lastId++);
        tasks.add(t);
        Collections.sort(tasks, new Comparators.CompareByPriority());
    }

    public void printByName() {
        ArrayList<Task> ta = new ArrayList<>();
        ta.addAll(tasks);
        Collections.sort(ta);
        System.out.println(String.format("%-5s %-20s %-5s %-5s %-10s %-10s %-15s \n", "id", "název", "prior", "cas", "stav", "zadáno", "zavislost"));

        for (Task t : ta) {
            System.out.println(t);
        }

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void resetReadyState(){
        for(Task t:tasks){
            t.setReady(0);
        }
    }
    
    
    /**
     *
     * @return
     */
    public Task chooseTask() {

        for (Task ta : tasks) {
            if ((ta.getDependecy() == null || ta.getDependecy().isFinished()) && !ta.isFinished()) {
                return ta;
            }

        }
        return null;

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        Collections.sort(tasks, new Comparators.CompareByPriority());
        sb.append(String.format("%-5s %-20s %-5s %-5s %-10s %-10s %-15s \n", "id", "název", "prior", "cas", "stav", "zadáno", "zavislost"));
        sb.append("\n");
        for (Task ta : tasks) {
            sb.append(ta);
            sb.append("\n");
        }

        return sb.toString();
    }

    public int size() {
        return tasks.size();
    }

    public Task getTaskByID(int id) {
        for (Task ta : tasks) {
            if (ta.getIdTask() == id) {
                return ta;
            }
        }
        return null;

    }

}
