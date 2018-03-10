package control;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class Desvelador{
	Tablero tablero;
	
	public Desvelador(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	

	
	public void desvelarCasilla(Tablero tablero, JButton casillita) {
		Coordenada coordenada = Convertidor.convertirACoordenada(casillita);
		Casilla casilla = tablero.getCasilla(coordenada); //no sirve, (si funciona) pero lo dejo por si acaso
		
		assert casilla!=null:"casilla no valida";
		// TODO llamamos a la casilla pero tambien al *tablero*         //contar las minas que faltan por descubrir, tablero.minas con marcador
		//porque el tablero debe buscar recursivamente las casillas a desvelar
		
		tablero.desvelarContigua(coordenada);
		
		
		
		
		
	}

}