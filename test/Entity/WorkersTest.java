/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import model.Worker;
import model.Workers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Euronics
 */
public class WorkersTest {

    public WorkersTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testAddWorker() throws Exception {
    }

    @Test
    public void testGetWorkers() {
    }

    @Test
    public void testSetWorkers() {
    }

    @Test
    public void testChooseWorkerWithMinHours() throws Exception {
        Worker w1 = new Worker("Prog1");
        Worker w2 = new Worker("Prog2");
        Workers workers = new Workers();
        workers.addWorker(w1);
        workers.addWorker(w2);
        w1.setHoursWorked(4);
        Worker expected = w2;
        assertEquals(expected, workers.chooseWorkerWithMinHours());
    }

    
    
    @Test
    public void testToString() {
    }

}
