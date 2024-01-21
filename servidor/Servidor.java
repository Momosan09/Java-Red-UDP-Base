package com.mygdx.appserverencasaservidor.red;

public class Servidor {
	
	public Servidor() {
		UtilesRed.hs = new HiloServidor();
		UtilesRed.hs.start();
	}
	
	public void cerrarHilo() {
		UtilesRed.hs.fin();
	}
}
