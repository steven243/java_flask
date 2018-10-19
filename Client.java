package proyectoSockets;


import java.io.*;  
import java.net.*; 
import java.lang.*;



public class Client {

	public static void main(String[] args) {
	
		try{      
	        Socket socket=new Socket("localhost",3000);  

	        DataOutputStream dout=new DataOutputStream(socket.getOutputStream());  
	        DataInputStream din=new DataInputStream(socket.getInputStream());


	        dout.writeUTF("Hola desde Eclipse :v");
	        dout.flush();

	        System.out.println("Mensaje Enviado... ");
	        String str = din.readUTF();//in.readLine();

	        System.out.println("Mensaje del servidor --> "+str);


	        dout.close();  
	        din.close();
	        socket.close();
	        }

	        catch(Exception e){
	        e.printStackTrace();}   

	}

}
