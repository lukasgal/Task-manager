/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lukáš Gál
 */
public final class TasksTableModel extends AbstractTableModel implements Serializable {

    private int columnCount;

    ImageIcon aboutIcon = new ImageIcon("about16.gif");
    ImageIcon addIcon = new ImageIcon("add16.gif");

    private final Class[] columnClasses = new Class[]{String.class, Integer.class, Integer.class, Date.class, String.class};

    private Tasks tasks;

    private final String[] columnNames = new String[]{ "název", "priorita", "čas", "zadáno", "závislost"};

    public TasksTableModel() {
        this.tasks = new Tasks();
    }

    public void addTask(Task t) {
        tasks.addTask(t);
        fireTableRowsInserted(0, 0);

    }

    public Tasks getTasks() {
        return tasks;
    }

    
    
    @Override
    public Object getValueAt(int row, int col) {

        Task t = tasks.getTasks().get(row);

        switch (col) {

            //case 0:
              //  return t.getIdTask();
            case 0:
                return t.getName();

            case 1:
                return t.getPriority();
            case 2:
                return t.getTime();

            //case 4:
              //  return t.getReady();
            case 3:
                return t.getInserted();
            case 4: {
                if (t.getDependecy() != null) {
                    return t.getDependecy().getName();
                } else {
                    return null;
                }
            }

        }
        return "";
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        super.setValueAt(o, i, i1);
        fireTableCellUpdated(i, i1);
    }

    @Override
    public String getColumnName(int col) {

        return columnNames[col];

    }

    public void delete_row(int raw) {
        if (!tasks.getTasks().isEmpty()) {
            tasks.getTasks().remove(raw);
            fireTableRowsDeleted(raw, raw);
        }
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public void setTasks(Tasks t) {
        this.tasks = t;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    public Task updateTask(Task t, int i) {
        tasks.getTasks().set(i, t);

        return null;

    }

    
    
}
