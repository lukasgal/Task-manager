/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lukáš Gál
 */
public final class WorkersTableModel extends AbstractTableModel implements Serializable {

    private int columnCount;

    private final Class[] columnClasses = new Class[]{String.class, Integer.class};

    private Workers workers;

    private final String[] columnNames = new String[]{"jméno", "odpracováno"};

    public WorkersTableModel() {
        this.workers = new Workers();
    }

    public Workers getWorkers() {
        return workers;
    }

    public void addWorker(Worker w) {
        try {
            workers.addWorker(w);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        fireTableRowsInserted(0, 0);

    }

    @Override
    public Object getValueAt(int row, int col) {

        Worker t = workers.getWorkers().get(row);

        switch (col) {

            case 0:
                return t.getName();
            case 1:
                return t.getTotalHours();
        }
        return "";
    }

    @Override
    public String getColumnName(int col) {

        return columnNames[col];

    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public void setWorkers(Workers t) {
        this.workers = t;
    }

    @Override
    public int getRowCount() {
        return workers.size();
    }

    public void delete_row(int raw) {
        if (!workers.getWorkers().isEmpty()) {
            workers.getWorkers().remove(raw);
            fireTableRowsDeleted(raw, raw);
        }
    }

}
