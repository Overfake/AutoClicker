/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclicker;

/**
 *
 * @author Max
 */
public class AutoClicker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mF = new MainFrame();
        mF.setSize(700,300);
        mF.setAlwaysOnTop(true);
        mF.setVisible(true);
    }
    
}
