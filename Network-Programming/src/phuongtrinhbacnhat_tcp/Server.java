/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtrinhbacnhat_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Hp
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        while(true){
            Socket sk = ss.accept();
            GiaiPhuongTrinh gpt = new GiaiPhuongTrinh(sk);
            gpt.start();
        }
    }
    
}
