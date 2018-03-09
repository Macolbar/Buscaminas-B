package modelo;

public enum Dificultad {
	FACIL(10),MEDIO(20),DIFICIL(30);
	
	private int numerominas;
	
	private Dificultad(int numerominas){
		this.numerominas=numerominas;
	}
	
	public int getMinas(){
		return numerominas;
	}
	
}


