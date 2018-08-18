package mundo;

import java.io.Serializable;

public class Seleccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Seleccion siguiente;
	private Seleccion anterior;
	private Jugador primero;
	// Creé esta nueva variable global
	private Jugador actual;
	private Jugador ultimo;

	// arboles

	private Seleccion hijoIzquierdo;
	private Seleccion hijoDerecho;

	private String nombre;
	private double puntos;
	private String rutaImagen;
	private String rutaBandera;

	public Seleccion() {
		// TODO Auto-generated constructor stub
	}

	public Seleccion(String nombre, double puntos, String ruta, String bandera) {
		// TODO Auto-generated constructor stub
		siguiente = null;
		anterior = null;
		primero = null;
		actual = null;
		ultimo = null;
		this.nombre = nombre;
		this.puntos = puntos;
		this.rutaImagen = ruta;
		rutaImagen = "";
		this.rutaBandera = bandera;
		setHijoIzquierdo(null);
		setHijoDerecho(null);

	}
	// ARBOLES BINARIOS Y RECURSIVIDAD:

	public void insertarSeleccion(Seleccion sel) {
		if (this.puntos > sel.getPuntos()) {
			if (hijoIzquierdo == null) {
				hijoIzquierdo = sel;
			} else {
				hijoIzquierdo.insertarSeleccion(sel);
			}
		} else {
			if (hijoDerecho == null) {
				hijoDerecho = sel;
			} else {
				hijoDerecho.insertarSeleccion(sel);
			}
		}

	}

	public Jugador buscarJugadorRecursivamente(Jugador aux, String nom) {
		if (aux == null) {
			return null;
		} else {
			if (aux.getNombre().equalsIgnoreCase(nom)) {
				return aux;
			} else {
				return buscarJugadorRecursivamente(aux.getSiguiente(), nom);
			}
		}
	}

	// __________________________________________________________________________________________________________________________________________
	public boolean listaVacia() {
		return primero == null;
	}

	public void agregarJugador(Jugador nuevoNodo) {

		if (listaVacia()) {
			primero = nuevoNodo;
			ultimo = primero;
			actual = ultimo;

		} else {
			ultimo.setSiguiente(nuevoNodo);
			nuevoNodo.setAnterior(ultimo);
			nuevoNodo.setSiguiente(primero);
			primero.setAnterior(nuevoNodo);
			ultimo = nuevoNodo;
			// Esto es nuevo, va a tener los mismos datos del actual. Esto para no modificar
			// al último en los recorrer.
			actual = ultimo;
			actual.setSiguiente(ultimo.getSiguiente());
			actual.setAnterior(ultimo.getAnterior());

		}
	}

	// En ambos recorrer siempre cambio el actual para que de una ves y que se pueda
	// visualizar en la interfaz el siguiente jugador.
	// La precondición es que previamente he seleccionado un jugador (sería lo
	// ideal), sino pues empieza por el actual.
	public void recorrerADerecha() {
		if (actual.getSiguiente() != null)
			setActual(actual.getSiguiente());

	}

	public void recorrerAIzquierda() {
		if (actual.getAnterior() != null)
			setActual(actual.getAnterior());
	}

	/**
	 * Coreija esto
	 * 
	 * @param name
	 */
	public void eliminarJugador(String name) {
		Jugador actual = primero;
		boolean encontro = false;
		while (actual != primero && !encontro) {
			if (actual.getNombre().equalsIgnoreCase(name)) {
				actual.getAnterior().setSiguiente(actual.getSiguiente());
				actual.getSiguiente().setAnterior(actual.getAnterior());
				encontro = true;
			} else {
				actual = actual.getSiguiente();
			}

		}
	}

	public Jugador buscarPorNombre(String name) {
		boolean encontro = false;
		Jugador actual = primero;
		Jugador jug = null;
		if (!listaVacia()) {
			while (actual != null && !encontro) {
				if (actual.getNombre().equalsIgnoreCase(name)) {
					jug = actual;
					encontro = true;

				} else {
					actual = actual.getSiguiente();

				}
			}
		}
		return jug;
	}

	public Seleccion getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Seleccion siguiente) {
		this.siguiente = siguiente;
	}

	public Seleccion getAnterior() {
		return anterior;
	}

	public void setAnterior(Seleccion anterior) {
		this.anterior = anterior;
	}

	public Jugador getPrimero() {
		return primero;
	}

	public void setPrimero(Jugador primero) {
		this.primero = primero;
	}

	public Jugador getUltimo() {
		return ultimo;
	}

	public void setUltimo(Jugador ultimo) {
		this.ultimo = ultimo;
	}

	public Jugador getActual() {
		return actual;
	}

	public void setActual(Jugador actual) {
		this.actual = actual;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public String getRutaBandera() {
		return rutaBandera;
	}

	public void setRutaBandera(String rutaBandera) {
		this.rutaBandera = rutaBandera;
	}

	public Seleccion getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(Seleccion hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	public Seleccion getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(Seleccion hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}

}
