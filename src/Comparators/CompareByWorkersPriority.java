/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Entity.Task;
import Entity.Worker;
import java.util.Comparator;

/**
 *
 * @author Euronics
 */
public class CompareByWorkersPriority implements Comparator<Worker>{

    @Override
    public int compare(Worker w, Worker w1) {
        return (w.getPriority()- w1.getPriority())*-1;
    }
    
}
