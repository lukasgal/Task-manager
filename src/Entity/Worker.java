package Entity;

/**
 *
 * @author Lukáš Gál
 */
public class Worker {

    private String name;
    private Integer hoursWorked;
    private int priority;
    private int totalHours;

    public Worker(String name) {
        this.name = name;
        this.hoursWorked = 0;
        this.totalHours = 0;
        this.priority = 0;
    }

    public void emptyHours() {
        this.hoursWorked = 0;
    }

    public boolean isFinished() {
        return (hoursWorked == Workers.MAX_DAILY_WORKING_HOURS);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int canWorkYet() {
        return Workers.MAX_DAILY_WORKING_HOURS - hoursWorked;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked += hoursWorked;
        this.totalHours += hoursWorked;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public String toString() {
        return String.format("%-20s %5d %5d\n", getName(), getHoursWorked(), getTotalHours());
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
