
package proyectoSockets;

import java.io.*;
import java.net.*;


public class Servidor {
    
    
    static final int PUERTO = 3000;
    
    public static void main(String[] args) throws IOException {
    //public Servidor() throws IOException{
        
        try{
            
            System.out.println("Iniciando Servidor...");
            //Creamos un objeto de la clase ServerSockets para esperar conexiones por el puerto designado
            ServerSocket socket_servidor = new ServerSocket(PUERTO);
            //Imprimimos que estamos escuchando al puerto
            System.out.println("Escucho al puerto: " + PUERTO);
            System.out.println("Esperando conexiones de los clientes...");
            
            //Mediante un ciclo, restringimos la atención do sólo 3 clientes
            for(int numCliente = 0; numCliente < 200 ; numCliente++){
            
            double sl = 4.5;	
            double sw = 3.4;	
            double pl = 1.8;	
            double pw = 3.2;	
            
            	
            String parametros = "{'sl':" + sl + ", 'sw':" + sw + ", 'pl':" + pl + ", 'pw':" + pw +"}" ;	
            
            //Creamos un objeto de la clase socket para gestionar las conexiones de cada cliente
            //El método .accept() crea un socket para atender a un cliente  que se ha conectado
            Socket socket_cliente = socket_servidor.accept();
            //Imprimimos en pantalla que estamos atendiendo al cliente #tal :v
            System.out.println("Sirvo al cliente : "+numCliente+", en el puerto de comunicación: " +  socket_cliente.getPort());
            //Creamos un stream de salida para enviar los mensajes a los clientes
            OutputStream mensajeParaCliente = socket_cliente.getOutputStream();
            //La clase DataOutStream es útil para escribir los datos de tipo primitivo de una forma portable
            DataOutputStream flujoSecuencial = new DataOutputStream(mensajeParaCliente);
            //Escribimos en el flujo secuencial del socket mediante el .writeUTF  y lo enviamos al cliente
            flujoSecuencial.writeUTF(parametros/*"Este es un mensaje enviado desde el servidor :v""Bienvenido cliente: " + numCliente + ".\n El puerto de eschucha es: " + socket_cliente.getLocalPort() + " y el puerto de comunicaciones bidereccional es: " + socket_cliente.getPort()*/ );
            /*Creamos un stream de entrada para recibir todos los mensajes del cliente
            InputStream mensajeCliente = socket_cliente.getInputStream();
            //Asociamos el flujo de datos del socket (obtenido desde un getInputStream) a un flujo del cliente(creo :v)
            //La clase DataOutStream es útil para escribir los datos de tipo primitivo de una forma portable
            DataInput flujoSecuencialCliente =  new DataInputStream(mensajeCliente);
            //Leemos el flujo secuencial del socket mediante .readUTf y lo imprimimos en pantalla (para leer los mensajes del cliente)
            System.out.println("El cliente #"+numCliente+": " + flujoSecuencialCliente.readUTF());*/
            
            InputStream is = socket_cliente.getInputStream();
            BufferedReader buf =new BufferedReader(new InputStreamReader(is));
            String mensaje = buf.readLine();
            System.out.println(mensaje);
            
            /*InputStream mensajeDelCliente = socket_cliente.getInputStream();
            DataInputStream din=new DataInputStream(mensajeDelCliente);
            String mensaje = din.readUTF();
            System.out.println(mensaje);*/
            //Cerramos el socket despues de haber enviado todos los mensajes
            socket_cliente.close(); 
                
            }
            
            
            System.out.println("Demasiados Clientes...");
            System.out.println("Solo puedo atender 3 clientes...");
            
        }catch(Exception e){
            
            System.out.println(e.getMessage()); 
   
        } 
    
    
    }
        
}
    

