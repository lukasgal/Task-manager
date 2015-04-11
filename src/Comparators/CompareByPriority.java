/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Entity.Task;
import java.util.Comparator;

/**
 *
 * @author Euronics
 */
public class CompareByPriority implements Comparator<Task>{

    @Override
    public int compare(Task t, Task t1) {
        return (t1.getPriority()- t.getPriority());
    }
    
}
