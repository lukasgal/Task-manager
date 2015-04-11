package Entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lukáš Gál
 */
public class Tasks {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task t){
        tasks.add(t);    
        Collections.sort(tasks,new Comparators.CompareByPriority());
    }
    
    public void printByName(){
        ArrayList<Task> ta = new ArrayList<>();
        ta.addAll(tasks);
        Collections.sort(ta);
        System.out.println(String.format("%-5s %-20s %-5s %-5s %-10s %-10s %-15s \n","id","název","prior","cas","stav","zadáno","zavislost"));
        
        for(Task t: ta){
            System.out.println(t);
        }
    
    }
    
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     *
     * @return
     */
    public Task chooseTask(){
        
        for(Task ta: getTasks()){
            if((ta.getDependecy()==null || ta.getDependecy().isFinished()) && !ta.isFinished())
                return ta;
            
        }
        return null;
    
    }
    
    
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        Collections.sort(tasks,new Comparators.CompareByPriority());
        sb.append(String.format("%-5s %-20s %-5s %-5s %-10s %-10s %-15s \n","id","název","prior","cas","stav","zadáno","zavislost"));
        sb.append("\n");
        for(Task ta:tasks){
            sb.append(ta);
            sb.append("\n");
        }
         
        return sb.toString();
    }
    
    
    
}
