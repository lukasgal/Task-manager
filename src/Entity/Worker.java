package Entity;

/**
 *
 * @author Lukáš Gál
 */
public class Worker implements Comparable<Worker>{
    private String name;
    private Integer hoursWorked;

    public Worker(String name) {
        this.name = name;
        this.hoursWorked = 0;
    }

    public void emptyHours(){
        this.hoursWorked = 0;
    }
    
    
    public boolean isFinished(){
        return (hoursWorked == Workers.MAX_DAILY_WORKING_HOURS);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int canWorkYet(){
        return Workers.MAX_DAILY_WORKING_HOURS - hoursWorked;
    }
    
    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked += hoursWorked;
    }

    @Override
    public int compareTo(Worker t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return String.format("%-20s %5d\n", getName(),getHoursWorked());
    }
    
    
}
