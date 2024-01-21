package com.mygdx.appserverencasa;

public class Cliente {

	public Cliente() {
		UtilesRed.hc = new HiloCliente();
		UtilesRed.hc.start();			
		UtilesRed.hc.enviarMensaje("conectar");		
	}


	public void cerrarCliente() {
		System.out.println("cerrando");
		UtilesRed.hc.fin();
		UtilesRed.hc.interrupt();
	}
}
