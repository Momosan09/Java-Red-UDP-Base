package com.mygdx.appserverencasa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class HiloServidor extends Thread{

	private DatagramSocket socket;
	private boolean fin = false;
	
	public HiloServidor() {
		try {
			System.out.println("servidor iniciado");
			socket = new DatagramSocket(333333);

		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
	    while (!fin) {
	        byte[] datos = new byte[1024];
	        DatagramPacket dp = new DatagramPacket(datos, datos.length);
	        System.out.println("Esperando mensaje...");
	        try {
	            socket.receive(dp);
	            procesarMensaje(dp);
	        } catch (IOException e) {
	            //e.printStackTrace();
	        }
	    }
	    System.out.println("Hilo del servidor finalizado."); // Agrega un mensaje aquí
	}


	private void procesarMensaje(DatagramPacket dp) {
		String msg = new String(dp.getData()).trim();//trim() lo que hace es sacar los espacios
		String[] mensajeCompuesto = msg.split("#");
	
		//System.out.println(HelpDebug.debub(getClass())+"mensaje de longitud " + mensajeCompuesto.length);
		
		switch (mensajeCompuesto[0]) {
		case value:
			
			break;

		default:
			break;
		}
		

		
		}
			
	
	
	public void enviarMensaje(String msg, InetAddress ipDestino, int puerto) {
		byte[] mensaje = msg.getBytes();
		try {
			DatagramPacket dp = new DatagramPacket(mensaje, mensaje.length, ipDestino, puerto);
			socket.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void fin() {
		fin = true;
		socket.close();
	}
	


}
