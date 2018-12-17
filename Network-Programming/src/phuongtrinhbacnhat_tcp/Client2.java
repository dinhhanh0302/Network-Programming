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
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket cl = new Socket("localhost", 1234);
		
        DataInputStream nhan = new DataInputStream(cl.getInputStream());
        DataOutputStream gui = new DataOutputStream(cl.getOutputStream());

        Scanner scan = new Scanner(System.in);
        System.out.println("Chương trình giải phương trình bậc nhất");

        System.out.println("Nhap a: ");
        int a = scan.nextInt();
        gui.writeInt(a);

        System.out.println("Nhap b: ");
        int b = scan.nextInt();
        gui.writeInt(b);
        
        String flag = nhan.readUTF();
		
        if(flag.equals("true")) {
            String kq = nhan.readUTF();
            System.out.println("Nghiệm phương trình x = " + kq);
        }
        else{
            String kq = nhan.readUTF();
            System.out.println(kq);
        }
    }
    
}
