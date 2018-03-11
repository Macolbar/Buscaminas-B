package modelo;


import javax.naming.event.NamespaceChangeListener;


import modelo.Casilla;
import modelo.Coordenada;
import utiles.Utiles;

public class Tablero {
	private Casilla[][] casillas;
	boolean ganador = false;
	boolean perdedor = false;
	

	public Casilla[][] getCasillas() {
		return casillas;
	}
	
	public Casilla getCasilla(Coordenada coordenada) { //esto es para llamar a una casilla en concreto (Convertidor
														//saca la coordenada del JButton y se identifica asi)
		return casillas[coordenada.getPosX()][coordenada.getPosY()];
	}
	
	public Tablero(Dificultad dificultad) {
		super();
		
		crearTablero(dificultad.getMinas());
	}

	private void crearTablero(int minas) {
		casillas = new Casilla[Utiles.DIEZ][Utiles.DIEZ];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(); 
			}
		}
		
		int x;
		int y;
		do{
			x= (int) Math.abs(Math.random()*Utiles.DIEZ);
			y= (int) Math.abs(Math.random()*Utiles.DIEZ);
			
			if(colocarMina(x,y)){
				minas--;
			}
		}while(minas!=0);
		calcularMinasAlrededor();
		
	}

	
	

	
	public void calcularMinasAlrededor() {
		// TODO recorrer el panel donde hay mina y colocar un incremento
		// de una mina alrededor de ella
		for (int i = 0; i < Utiles.DIEZ; i++) {
			for (int j = 0; j < Utiles.DIEZ; j++) {
				if (getCasilla(new Coordenada(i, j)).isMina()) {
					Coordenada coordenada[] = new Utiles().damePosicionAlrededor(i, j);
					Coordenada validas[] = new Utiles().validaContiguas(coordenada, casillas.length - 1);
					for (int k = 0; k < validas.length; k++) {
						if (!getCasilla(new Coordenada(validas[k].getPosX(), validas[k].getPosY())).isMina()) {
							getCasilla(new Coordenada(validas[k].getPosX(), validas[k].getPosY())).setAlrededor();
						}
					}
				}
			}
		}
	}





	public boolean colocarMina(int x, int y) {
		// no se debe acceder directamente a las propiedades de otra clase
		// casilla[x][y].mina=true;

		return casillas[x][y].colocaMina();
	}

	

	
	public void desvelarContigua(Coordenada casilla) {
		// lo que hay que hacer siempre
		// es velar una casilla
		setOculta(casilla);
		// comprobar si las casillas marcadas alrededor coincide con el
		// numero de minas alrededor de la casilla
		if (comprobarMarcadas(casilla)) {
			for (int i = 0; i < Utiles.OCHO; i++) {
				Coordenada coordenada[] = new Utiles().damePosicionAlrededor(casilla.getPosX(),casilla.getPosY());
				Coordenada validas[] = new Utiles().validaContiguas(coordenada, casillas.length - 1);
				if (isOculta(validas[i])
						&& !isMarcada(validas[i])) {
					setOculta(casilla);
					if (getAlrededor(casilla) == 0)
						desvelarContigua(validas[i]);
				}
			}
		}
	}



	/**
	 * Comporbar si el numero de casillas marcadas alrededor de una casilla
	 * coincide con el numero de minas alrededor de una casilla
	 * 
	 * @param lugar
	 * @return
	 */
	public boolean comprobarMarcadas(Coordenada lugar) {
		int contador = 0;
		// es contar cuantas casilla marcadas rodean a la actual
		for (int i = 0; i < Utiles.OCHO; i++) {
			Coordenada coordenada[] = new Utiles().damePosicionAlrededor(lugar.getPosX(),lugar.getPosY());
			Coordenada validas[] = new Utiles().validaContiguas(coordenada, Utiles.DIEZ - 1);
			
				if (isMarcada(validas[i])) {
					contador++;
				}
			
		}
		boolean retorno = false;
		if (contador == casillas[lugar.getPosX()][lugar.getPosY()].getAlrededor()
				&& !casillas[lugar.getPosX()][lugar.getPosY()].isMina())
			retorno = true;
		return retorno;
	}
	
	
	
	
	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public boolean isPerdedor() {
		return perdedor;
	}

	public void setPerdedor(boolean perdedor) {
		this.perdedor = perdedor;
	}
	
	
	
	
	/*yo a esto apenas le hago caso, llamo directamente desde las casillas, creo que solo lo uso aqui
	
	tablero.getCasilla(Coordenada); ..*/
	
	public byte getAlrededor(Coordenada lugar) {
		
		return casillas[lugar.getPosX()][lugar.getPosY()].getAlrededor();
	}

	public boolean isMarcada(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isMarcada();
	}

	public boolean isOculta(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isOculta();
	}

	public void setOculta(Coordenada lugar) {
		casillas[lugar.getPosX()][lugar.getPosY()].setOculta(false);
	}
	

}
