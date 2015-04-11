
import Entity.Task;
import Entity.TaskSheduler;
import Entity.Tasks;
import Entity.Worker;
import Entity.Workers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Euronics
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        Task t1 = new Task("1.", 50, 10);
        Task t2 = new Task("1.1.", 40, 8);
        Task t3 = new Task("2.", 80, 12);
        Task t4 = new Task("3.", 60, 7);
        Task t5 = new Task("2.2.", 60, 8);
        Task t6 = new Task("2.2.2", 60, 8);
        Task t7 = new Task("2.2.3", 60, 8);
        Task t8 = new Task("2.1.", 70, 8);
        
        t1.setInserted(new Date(Date.parse("2015/04/01")));
        t2.setInserted(new Date(Date.parse("2015/04/05")));
        t3.setInserted(new Date(Date.parse("2015/04/02")));
        t4.setInserted(new Date(Date.parse("2015/04/04")));
        t5.setInserted(new Date(Date.parse("2015/04/02")));
        
        t2.setParent(t2);
        t5.setParent(t3);
        t6.setParent(t5);
        t7.setParent(t6);
        t8.setParent(t3);
        
        t2.setDependecy(t1);
        t3.setDependecy(t1);
        t4.setDependecy(t3);
        t5.setDependecy(t3);
        t6.setDependecy(t5);
        t7.setDependecy(t6);
        t8.setDependecy(t3);

        //t1.setReady(t1.getTime());
        //t3.setReady(t3.getTime());
        //t4.setReady(t4.getTime());

        Tasks tasks = new Tasks();
        
        tasks.addTask(t1);
        tasks.addTask(t2);
        tasks.addTask(t3);
        tasks.addTask(t4);
        tasks.addTask(t5);
        tasks.addTask(t6);
        tasks.addTask(t7);
        tasks.addTask(t8);
        
        System.out.println(tasks);
        
        Worker w1 = new Worker("Prog1");
        Worker w2 = new Worker("Prog2");
        Workers workers = new Workers();
        workers.addWorker(w1);
        workers.addWorker(w2);
        w2.setHoursWorked(5);
        System.out.println(tasks.chooseTask());
        System.out.println(workers);
        System.out.println(workers.chooseWorkerWithMinHours());
        TaskSheduler ts = new TaskSheduler(tasks, workers);
        ts.plan();
        System.out.println("------------------");
        
        System.out.println(tasks.chooseTask());
        
        System.out.println(workers);
        
    }
    
}

