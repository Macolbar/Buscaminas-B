package modelo;

public interface AccionesTablero {
	/**
	 * por cada sitio, calcula el número de minas que tiene alrededor
	 */
	void calcularMinasAlrededor(Tablero tablero);
	void desvelarContigua(Coordenada lugar);
}
