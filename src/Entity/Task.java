/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Euronics
 */
public class Task {
    
    private String name;
    private Integer priority;
    private Task parent;
    private Integer time;
    private Task dependecy;

    public Task(String name, Integer priority, Integer time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
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
    
    
    
    
    
    
}
