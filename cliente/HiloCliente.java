package com.mygdx.appserverencasa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class HiloCliente extends Thread{

	private DatagramSocket socket;
	private boolean fin = false;
	private InetAddress ipServer;
	private int puerto = 35323;//El puerto del servidor siempre va a estar fijo


	public HiloCliente() {

		try {
			socket = new DatagramSocket();
			//socket.setReuseAddress(true); // Permite reutilizar el puerto
			ipServer = InetAddress.getByName("255.255.255.255");//Broadcast
		} catch (SocketException | UnknownHostException e) {
			fin = true;
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		do {
			byte[] datos = new byte[1024];
			DatagramPacket dp = new DatagramPacket(datos, datos.length);
			try {
				socket.receive(dp);
				procesarMensaje(dp);
			} catch (IOException e) {
				//e.printStackTrace();

			}
		}while(!fin);
		socket.close(); // Cierra el socket al salir del bucle
	}

	private void procesarMensaje(DatagramPacket dp) {
		String msg = new String(dp.getData()).trim();//trim() lo que hace es sacar los espacios
		String[] mensajeCompuesto = msg.split("#");
		
		switch (mensajeCompuesto[0]) {
		case value:
			
			break;

		default:
			break;
		}
	}


	public void enviarMensaje(String msg) {
		byte[] mensaje = msg.getBytes();

		try {
			DatagramPacket dp = new DatagramPacket(mensaje, mensaje.length, ipServer, puerto);
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