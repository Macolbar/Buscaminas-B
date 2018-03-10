package control;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;

public class Convertidor {
	
	public static Coordenada convertirACoordenada(JButton boton) {
		String[]coordenada = boton.getName().split(",");
	
		int x=Integer.parseInt(coordenada[0]);
		int y=Integer.parseInt(coordenada[1]);
	

	return new Coordenada(x,y);
}

}
