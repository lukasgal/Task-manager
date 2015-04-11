
package Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Lukáš Gál
 */
public class Task{
    
    private String name;
    private Integer priority;
    private Task parent;
    private Integer time;
    private Task dependecy;
    private Integer ready;
    private Date inserted;
    private final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    

    public Task(String name, Integer priority, Integer time){
        this.name = name;
        this.priority = priority;
        this.time = time;
        this.ready = 0;
        this.inserted = new Date();
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getStatusTime() {
        return (time - ready);
    }

    
    public void setReady(Integer ready) {
        this.ready += ready;
    }

    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Task getParent() {
        return parent;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Task getDependecy() {
        return dependecy;
    }

    public void setDependecy(Task dependecy) {
        this.dependecy = dependecy;
    }

    public boolean isFinished() {
        return (time==ready);
    }
    
    public boolean isReadyDependentTask(){
        return (dependecy.isFinished());
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }
    
    
    
    
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(String.format("-> %-20s %4d %4d %4d\t%-20s", getName(),getPriority(),getTime(),getStatusTime(), df.format(inserted)));
        
        
        sb.append("\t");
        sb.append(getDependecy());
        return sb.toString();
    }

    
    
    
    
    
    
    
    
}
