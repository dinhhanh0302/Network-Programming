/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtrinhbacnhat_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class GiaiPhuongTrinh extends Thread{

    private final Socket socket;
    
    public GiaiPhuongTrinh(Socket sk){
        socket = sk;
    }
    
    @Override
    public void run() {
        DataInputStream nhan;
        DataOutputStream gui;
        try {
            nhan = new DataInputStream(socket.getInputStream());
            gui = new DataOutputStream(socket.getOutputStream());
            
            int a = nhan.readInt();
            int b = nhan.readInt();
            
            System.out.println("\n a = " + a + "\tb = " + b  );
            
            
            if(a == 0){
                if(b == 0){
                    gui.writeUTF("false");
                    gui.writeUTF("Phương trình có vô số nghiệm");
                }
                else{
                    gui.writeUTF("false");
                    gui.writeUTF("Phương trình có vô nghiệm");
                }
            }
            else{
                float x = (float)-b/a;
                String tam = "" + x;
                gui.writeUTF("true");
                gui.writeUTF(tam);
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(GiaiPhuongTrinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
