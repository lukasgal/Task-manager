
import model.Task;
import model.TaskManager;
import model.Tasks;
import model.Worker;
import model.Workers;
import java.util.Date;
import javax.swing.JFrame;
import view.MainForm;


/**
 *
 * @author Lukas Gal
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        Task t1 = new Task("1.", 50, 3);
        Task t2 = new Task("1.1.", 40, 12);
        Task t3 = new Task("2.", 80, 5);
        Task t4 = new Task("3.", 60, 4);
        Task t5 = new Task("2.2.", 60, 5);
        Task t6 = new Task("2.2.2.", 60, 12);
        Task t7 = new Task("2.2.3.", 60, 6);
        Task t8 = new Task("2.1.", 70, 7);
        
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
        
        MainForm form = new MainForm();
        //form.setTasks(tasks);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
        
        
        System.out.println("=================================");
        System.out.println("Seznam ukolu hierarchicky");
        System.out.println("=================================");
        tasks.printByName();
        System.out.println("");
        System.out.println("=================================");
        System.out.println("Seznam ukolu podle priority");
        System.out.println("=================================");
        System.out.println(tasks);
        System.out.println("");
        System.out.println("Pracovnici");
        Worker w1 = new Worker("Petr");
        Worker w2 = new Worker("Karel");
        Worker w3 = new Worker("Matouš");
        Worker w4 = new Worker("Jan");
        
        Workers workers = new Workers();
        workers.addWorker(w1);
        workers.addWorker(w2);
        //workers.addWorker(w3);
        //workers.addWorker(w4);        
        
        System.out.println("=================================");
        System.out.println(workers);
        
        TaskManager ts = new TaskManager(tasks, workers);
        System.out.println(ts.plan().toString());
        
        System.out.println(workers);
        
        
        
        
        
    }
    
}


