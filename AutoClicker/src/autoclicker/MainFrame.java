/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclicker;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Max
 */
public class MainFrame extends javax.swing.JFrame  {
    private int x,y;
    private ClickLoop CL;
    private boolean useTimer = false;
    public MainFrame() {
        initComponents();
        this.setFocusable(true);
        x = -1;
        y = -1; 
        this.CL = new ClickLoop(x, y, 3000);
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                requestFocus();
            }
         });
        this.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) { 
                if(e.isControlDown()){
                        PointerInfo a = MouseInfo.getPointerInfo();
                        Point b = a.getLocation();
                        x = (int) b.getX();
                        y = (int) b.getY();
                }
                System.out.println(x+" "+y);
                
            }
            public void keyReleased(KeyEvent e) { }

            public void keyTyped(KeyEvent e) { }
        });
    }
    private boolean positionIsSelected(){
        return !(x == -1 && y == -1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Use a timer or a number of total clicks ?");
        jPanel2.add(jLabel4);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Number of clicks");
        jPanel2.add(jLabel3);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose interval in miliseconds");
        jPanel2.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click here and thenpress CTRL to select cursor position");
        jPanel2.add(jLabel2);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(0, 1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Define number of clicks", "Use a timer" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("10");
        jPanel3.add(jTextField2);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("1000");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1);

        jButton1.setText("Click here to start AutoClicker bot");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    public void ended(){
 //        this.CL.arreter();
         this.CL = new ClickLoop(x, y, getInteger(jTextField1.getText()));//create a new one because it would bug if we click start twice
        jButton1.setText("Click here to start AutoClicker bot");
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(positionIsSelected()){
          this.CL.setSSuper(this);//to make the button show when the bot is done working
        if(jButton1.getText().equals("Click here to start AutoClicker bot")){
            jButton1.setText("Click here to stop AutoClicker bot");
            this.CL.resetClickBot(x, y, Integer.parseInt(jTextField1.getText()));
            if(this.useTimer){
                this.CL.setTimer(getInteger(jTextField2.getText()));
            }
            else{
                this.CL.setNbClicks(getInteger(jTextField2.getText()));
            }
            this.CL.start();
        }
        else{
            this.CL.arreter();
            
        }
      }else{
          System.out.println("Error windows : you didn't selected a cursor position, try CTRL.");
      }
    }//GEN-LAST:event_jButton1ActionPerformed
    private int getInteger(String s){
        int res = 0;
        try{
            res = Integer.parseInt(s);
        }catch(NumberFormatException ex){
             System.out.println("Number FORMAT EXEPTION");
        }
        return res;
    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //
       if(String.valueOf(jComboBox1.getSelectedItem()).equals("Use a timer")){
           this.useTimer = true;
           jLabel3.setText("Time in seconds");
       }
       else{
           this.useTimer = false;
           jLabel3.setText("Nomber of clicks");
       }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
