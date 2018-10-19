import socket
import json as js

HOST = 'localhost'
PORT = 3000

#print(type(mensaje))

with socket.socket(socket.AF_INET , socket.SOCK_STREAM) as s:

    s.connect((HOST,PORT))
    s.send("Hola desde python".encode('UTF-8'))
    data = s.recv(1024).decode('UTF-8').replace("(","")
    data = data.replace("'","\"")
    print (type(data))
   
    """
    datos = js.loads(data)
    print(type(datos))
    
    sl = data['sl']
    print(sl)
    
    #data2 = float(data)e
    #print (type(data2))
    """
    
print ('Recibido --> ' , (data))
#print (type(ne)


""" mensaje = "Hola desde python :v "
    mensaje_2 = len(mensaje).to_bytes(2, byteorder='big')"""
