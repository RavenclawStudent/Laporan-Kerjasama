/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapor.kerma;

import java.nio.file.Paths;
import lapor.kerma.frame.KermaFrame;
import lapor.kerma.model.Login;

/**
 *
 * @author ODETTE
 */
public class LaporKerMa {
    static LaporKerMa instance = null;
    static Login activeLogin = null;
    /**
     * @param args the command line arguments
     */
    public static LaporKerMa getInstance() {
        if (instance == null) {
            instance = new LaporKerMa();
        }
        return instance;
    }

    public static void setActiveLogin(Login login) {
        activeLogin = login;
    }

    public static Login getActiveLogin() {
        return activeLogin;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //SimanisApp.getInstance().getLoginController().displayLoginFrame();
                KermaFrame kermasFrame = KermaFrame.getInstance();

                kermasFrame.tampilkanMenuAdmin(false);

                kermasFrame.setVisible(true);

            }
        });
    }
    
}

