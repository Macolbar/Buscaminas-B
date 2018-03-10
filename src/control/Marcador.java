package control;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class Marcador { // voy a hacer lo mismo con el marcador(y quito la interface porque si no no me deja
	//poner el Jbutton

	
	public void marcarCasilla(JButton casillita, Tablero tablero) {
		Coordenada coordenada = Convertidor.convertirACoordenada(casillita);
		Casilla casilla = new Casilla();
		casilla.setCoordenada(coordenada);
		casilla = tablero.getCasilla(coordenada);
		assert casilla!=null:"casilla no valida";
		
		if(casilla.isOculta()){
			casilla.setMarcada(!casilla.isMarcada());
			if(casilla.isMarcada()){
				casillita.setText("B");
			}
			else{
				casillita.setText("");
			}
		}
		
		
	}

	
	
}
