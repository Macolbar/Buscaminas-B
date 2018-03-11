package control;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;

public class Marcador { // voy a hacer lo mismo con el marcador(y quito la interface porque si no no me deja
	//poner el Jbutton

	protected ImageIcon bandera = new ImageIcon(getClass().getResource("/assets/bandera.png"));
	
	public void marcarCasilla(JButton casillita, Tablero tablero) {
		Coordenada coordenada = Utiles.convertirACoordenada(casillita);
		Casilla casilla = new Casilla();
		casilla.setCoordenada(coordenada);
		casilla = tablero.getCasilla(coordenada);
		assert casilla!=null:"casilla no valida";
		
		if(casilla.isOculta()){
			casilla.setMarcada(!casilla.isMarcada());
			if(casilla.isMarcada()){
				casillita.setText("X");
			}
			else{
				casillita.setText("");
			}
		}
		
		
	}

	
	
}
