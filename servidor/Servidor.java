package com.mygdx.appserverencasa;

public class Servidor {

	private HiloServidor hs;
	
	public Servidor() {
		hs = new HiloServidor();
		hs.start();

		hs = UtilesRed.hs;
	}
	
	public void cerrarHilo() {
		hs.fin();//sacar de aca
	}
}