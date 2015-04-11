/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lukáš Gál
 */
public class WorkingDay {

    private Integer id;
    private Date date;
    private ArrayList<SolvingTask> solved = new ArrayList<>();

    public WorkingDay(Integer id) {
        this.id = id;
    }

    public void addSolvingTask(SolvingTask st) {
        solved.add(st);

    }

    public ArrayList<SolvingTask> getSolved() {
        return solved;
    }

    public ArrayList<SolvingTask> getUnfinishedTasks() {
        ArrayList<SolvingTask> st = new ArrayList<>();
        
        for (SolvingTask s : solved) {
            if (!s.getTask().isFinished()) {
                st.add(s);
            }
        }

        return st;

    }

    public void setSolved(ArrayList<SolvingTask> solved) {
        this.solved = solved;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("============================\n");
        sb.append("\tWORKING DAY " + id + "\n");
        sb.append("============================\n");
        sb.append(String.format("%-10s %-5s\t\t %-10s %-5s  %-5s %-5s\n", "pracovnik", "odprac./den", "ukol", "cas", "zbyva", "odpracovano"));
        return sb.toString();
    }

}
