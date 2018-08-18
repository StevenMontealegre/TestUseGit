package mundo;

public class Jugador {

	private Jugador siguiente;
	private Jugador anterior;
	private String nombre, posicion, rutaImagen;
	private double puntajeFifa, edad, altura;

	public Jugador(String nombre, String posicion, double puntajeFifa, double edad, double altura, String rutaImagen) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.puntajeFifa = puntajeFifa;
		this.edad = edad;
		this.altura = altura;
		this.rutaImagen = rutaImagen;
		siguiente = null;
		anterior = null;
	}

	public Jugador getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Jugador siguiente) {
		this.siguiente = siguiente;
	}

	public Jugador getAnterior() {
		return anterior;
	}

	public void setAnterior(Jugador anterior) {
		this.anterior = anterior;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public double getPuntajeFifa() {
		return puntajeFifa;
	}

	public void setPuntajeFifa(double puntajeFifa) {
		this.puntajeFifa = puntajeFifa;
	}

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
