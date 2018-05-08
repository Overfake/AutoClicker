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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(positionIsSelected()){
        if(jButton1.getText().equals("Click here to start AutoClicker bot")){
            jButton1.setText("Click here to stop AutoClicker bot");
            this.CL.resetClickBot(x, y, Integer.parseInt(jTextField1.getText()));
            this.CL.start();
        }
        else{
            this.CL.arreter();
            this.CL = new ClickLoop(x, y, Integer.parseInt(jTextField1.getText()));
            jButton1.setText("Click here to start AutoClicker bot");
        }
      }else{
          System.out.println("Error windows : you didn't selected a cursor position, try CTRL.");
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
