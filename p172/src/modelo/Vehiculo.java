package modelo;

public class Vehiculo {

	private int distanciaRecorrida;
	private int puntaje;
	private boolean detenido;
	public final static int AVANCE = 5;
	private int posX;
	private int posY;

	public Vehiculo() {
		// TODO Auto-generated constructor stub
		this.distanciaRecorrida = 0;
		this.detenido = false;
		this.puntaje = 0;
		this.posX = 0;
		this.posY = 250;

	}

	public void reiniciar() {

	}

	public int darDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public void setDistanciaRecorrida(int dis) {
		distanciaRecorrida = dis;
	}

	public boolean estaDetenido() {
		return detenido;
	}

	public void avanzar(int avance) {

		posX += avance;
		if (posX > 1500) {
			posX = 0;
		}

	}

	public boolean setDetenido(boolean estado) {
		return detenido = estado;
	}

	public void detener() {

	}

	public void calcularPuntaje(int a, int b, int c) {

	}

	public int darPuntaje() {
		return puntaje;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
