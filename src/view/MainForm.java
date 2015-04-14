/*
 * To change this licens
 @Override
 public Object getValue(String string) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public void putValue(String string, Object o) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public void setEnabled(boolean bln) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public boolean isEnabled() {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public void addPropertyChangeListener(PropertyChangeListener pl) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public void removePropertyChangeListener(PropertyChangeListener pl) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public void actionPerformed(ActionEvent ae) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }
 e header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Task;
import model.TaskManager;
import model.Tasks;
import model.TasksTableModel;
import model.Worker;
import model.Workers;
import model.WorkersTableModel;

/**
 *
 * @author Euronics
 */
public final class MainForm extends javax.swing.JFrame {

    Workers workers;
    StringBuilder sb;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        setTitle("Task manager");
        workers = new Workers();
        initComponents();

        jTable1.setModel(new TasksTableModel());
        jTable2.setModel(new WorkersTableModel());
        
        try {
            load("tasks.dat", ((TasksTableModel) jTable1.getModel()).getTasks().getTasks());
            load("workers.dat", workers.getWorkers());
            resetTimes();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Soubor s daty se nepodařilo načíst.");
        }

        
        ((WorkersTableModel) jTable2.getModel()).setWorkers(workers);
        jTable1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    Task t = ((TasksTableModel) jTable1.getModel()).getTasks().getTasks().get(jTable1.getSelectedRow());
                    ke.consume();
                    final AddTaskForm zf = new AddTaskForm(null, t, getTasks());

                    zf.initForm();

                    zf.setLocationRelativeTo(jTable1);
                    zf.getCreate().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            ((TasksTableModel) jTable1.getModel()).updateTask(zf.getTask(), jTable1.getSelectedRow());
                            jTable1.repaint();
                            zf.dispose();
                        }
                    });
                    zf.setVisible(true);
                }
                 if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
                    //((TasksTableModel) jTable1.getModel()).getTasks().getTasks().remove(jTable1.getSelectedRow());
                    ((TasksTableModel) jTable1.getModel()).delete_row(jTable1.getSelectedRow());
                    //jTable1.repaint();
                 }
            }
            

        });

        jTable2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {
                 if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
                    //((TasksTableModel) jTable1.getModel()).getTasks().getTasks().remove(jTable1.getSelectedRow());
                    ((WorkersTableModel) jTable2.getModel()).delete_row(jTable2.getSelectedRow());
                    //jTable1.repaint();
                 }
            }
            

        });

        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.out.println("formclose");
                try {
                    save("tasks.dat", ((TasksTableModel) jTable1.getModel()).getTasks().getTasks());
                    save("workers.dat", ((WorkersTableModel) jTable2.getModel()).getWorkers().getWorkers());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Nepodařilo se uložit pracovníky.");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        createTask = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        jSplitPane1.setDividerLocation(470);
        jSplitPane1.setDividerSize(3);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(600, 390));

        jScrollPane2.setMinimumSize(new java.awt.Dimension(110, 23));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new TasksTableModel());
        jScrollPane2.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleDescription("");

        jSplitPane1.setLeftComponent(jScrollPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jSplitPane1.setRightComponent(jScrollPane1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(582, 64));

        jButton1.setText("Vložit událost");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Vložit pracovníka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Generovat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("O programu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(28, 28, 28)
                .addComponent(jButton4)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("Úkol");

        createTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add_task.png"))); // NOI18N
        createTask.setText("Vytvořit úkol");
        createTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskActionPerformed(evt);
            }
        });
        jMenu1.add(createTask);

        jMenuItem4.setText("Naplánovat");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Pracovníci");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/workers_show.png"))); // NOI18N
        jMenuItem3.setText("Zobrazit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Nápověda");

        jMenuItem5.setText("O programu");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTaskActionPerformed

    }//GEN-LAST:event_createTaskActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Task newTask = new Task(null, 50, 0);
        AddTaskForm at = new AddTaskForm(this, newTask, getTasks());

        at.setVisible(true);
        if (newTask.getName() != null) {
            ((TasksTableModel) jTable1.getModel()).addTask(newTask);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        GenerateForm gf = new GenerateForm(this, false);
        gf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                resetTimes();
            }

        });
        this.sb = new StringBuilder();
        TaskManager ts = new TaskManager(getTasks(), workers);
        StringBuilder result = ts.plan();

        sb.append("*********************************************************************\n");
        sb.append("\t\tN A P L Á N O V A N É  U D Á L O S T I\n");
        sb.append("*********************************************************************\n");
        sb.append(result);
        gf.getOutput().setText(sb.toString());
        //System.out.println(result);
        gf.setVisible(true);
        jTable2.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String w = JOptionPane.showInputDialog(this, "Jméno:", null);
        if (w != null) {
            ((WorkersTableModel) jTable2.getModel()).addWorker(new Worker(w));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(this, "Task manager\nAutor: Lukáš Gál");
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            //for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            //if ("Windows".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //  break;
            //}
            //}
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    public void resetTimes() {
        for (int i = 0; i < ((TasksTableModel) jTable1.getModel()).getTasks().getTasks().size(); i++) {
            int ready = ((Task) ((TasksTableModel) jTable1.getModel()).getTasks().getTasks().get(i)).getReady();
            ((Task) ((TasksTableModel) jTable1.getModel()).getTasks().getTasks().get(i)).setReady(-ready);
            jTable1.repaint();
        }
        
            for (int i = 0; i < ((WorkersTableModel) jTable2.getModel()).getWorkers().getWorkers().size(); i++) {
                ((Worker) ((WorkersTableModel) jTable2.getModel()).getWorkers().getWorkers().get(i)).setTotalHours(0);
                jTable2.repaint();
        }
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem createTask;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    public void setTasks(Tasks t) {
        ((TasksTableModel) jTable1.getModel()).setTasks(t);
    }

    public Tasks getTasks() {
        return ((TasksTableModel) jTable1.getModel()).getTasks();
    }

    public static Object deepClone(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void save(String fileName, List<?> l) throws FileNotFoundException, IOException {
        String tmp = l.toString();

        try {

            File file = new File(fileName);
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
            for (Object d : l) {

                out.writeObject(d);
            }
            out.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void load(String fileName, List l) throws FileNotFoundException {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.length() > 0) {
                FileInputStream is = new FileInputStream(file);

                ObjectInputStream in = new ObjectInputStream(is);
                while (is.available() > 0) {

                    Object d = (Object) in.readObject();
                    l.add(d);
                }

                in.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }
}
