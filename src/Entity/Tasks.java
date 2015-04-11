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
        sb.append(String.format("%-25s %-5s %-5s %-5s %-20s %-20s \n","název","prior","cas","stav","zadáno","zavislost"));
        sb.append("\n");
        for(Task ta:tasks){
            sb.append(ta);
            sb.append("\n");
        }
         
        return sb.toString();
    }
    
    
    
}
