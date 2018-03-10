package control;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class Marcador { // voy a hacer lo mismo con el marcador(y quito la interface porque si no no me deja
	//poner el Jbutton

	
	public boolean marcarCasilla(Tablero tablero, JButton casillita) {
		Coordenada coordenada = Convertidor.convertirACoordenada(casillita);
		Casilla casilla = tablero.getCasilla(coordenada); //no sirve, (si funciona) pero lo dejo por si acaso
		
		assert casilla!=null:"casilla no valida";
		
		return casilla.marcaCasilla();
	}

	
	
}
