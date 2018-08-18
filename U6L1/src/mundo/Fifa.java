package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Fifa {

	private Seleccion primero;
	private Seleccion actual;
	private Seleccion nodoAnterior;
	private Seleccion raiz;
	private int numeroElementos, altura;
	private File file;
	private Seleccion[] niveles;

	public Fifa() {
		// TODO Auto-generated constructor stub
		// recuperarSelecciones();
		setRaiz(null);
		primero = null;
		setActual(null);
		setNodoAnterior(null);
		setNumeroElementos(0);
		setAltura(0);
		file = null;
		recuperarSelecciones();
		System.out.println(numeroElementos);

	}

	// ARBOLES
	// BINARIOS___________________________________________________________________________________________________________________________

	public boolean arbolVacio() {
		return raiz == null;
	}

	public void agregarArbolSeleccion(Seleccion nuevoNodo) {
		actual = nuevoNodo;
		if (arbolVacio()) {
			raiz = nuevoNodo;
		} else {
			if (nuevoNodo.getPuntos() < raiz.getPuntos()) {
				if (raiz.getHijoIzquierdo() == null) {
					raiz.setHijoIzquierdo(nuevoNodo);
				} else {
					raiz.getHijoIzquierdo().insertarSeleccion(nuevoNodo);
				}
			}
			if (nuevoNodo.getPuntos() > raiz.getPuntos()) {
				if (raiz.getHijoDerecho() == null) {
					raiz.setHijoDerecho(nuevoNodo);
				} else {
					raiz.getHijoDerecho().insertarSeleccion(nuevoNodo);
				}

			}
		}

	}

	public void recorrerInOrden(Seleccion r) {
		if (r != null) {
			recorrerInOrden(r.getHijoIzquierdo());
			System.out.println(r.getRutaBandera());
			recorrerInOrden(r.getHijoDerecho());
		}

	}

	public Seleccion buscarEnArbolPorNombre(String nombre) {
		return buscarEnArbolPorNombre(raiz, nombre);

	}

	private Seleccion buscarEnArbolPorNombre(Seleccion aux, String nom) {
		if (aux == null) {
			return null;
		}
		int cmp = nom.compareToIgnoreCase(aux.getNombre());
		if (cmp < 0) {
			return buscarEnArbolPorNombre(aux.getHijoIzquierdo(), nom);

		} else if (cmp > 0) {
			return buscarEnArbolPorNombre(aux.getHijoDerecho(), nom);
		} else {
			return aux;
		}
	}

	public int retornarAltura() {
		altura = 0;
		retornarAltura(raiz, 1);
		return altura;

	}

	private void retornarAltura(Seleccion nodo, int nivel) {
		if (nodo != null) {
			retornarAltura(nodo.getHijoIzquierdo(), nivel + 1);
			if (nivel > altura) {
				altura = nivel;

			}
			retornarAltura(nodo.getHijoDerecho(), nivel + 1);
		}

	}

	public void imprimirNivel() {
		niveles = new Seleccion[altura + 1];
		imprimirNivel(raiz, 0);
		for (int i = 0; i < niveles.length; i++) {
			System.out.println(niveles[i] + " En el nivel: " + i);
		}
	}

	private void imprimirNivel(Seleccion pivote, int nivel2) {
		if (pivote != null) {
			niveles[nivel2] = ((niveles[nivel2] != null) ? niveles[nivel2] : null);
			imprimirNivel(pivote.getHijoDerecho(), nivel2 + 1);
			imprimirNivel(pivote.getHijoIzquierdo(), nivel2 + 1);
		}
	}

	// LISTAS
	// ENLAZADAS_______________________________________________________________________________________________________________________
	public boolean listaVacia() {
		return primero == null;
	}

	// Aquí simplemente le di uso a la variable actual, que sea igual a primero.
	public void agregarSeleccion(Seleccion nuevoNodo) {

		if (listaVacia()) {
			primero = nuevoNodo;
			actual = primero;
			numeroElementos++;

		} else {
			nuevoNodo.setSiguiente(primero);
			primero = nuevoNodo;
			actual = primero;
			numeroElementos++;
		}

	}

	public Seleccion buscarPorNombre(String name) {
		boolean encontro = false;
		Seleccion sel = null;
		if (!listaVacia()) {
			actual = primero;
			while (actual != null && !encontro) {
				if (actual.getNombre().equalsIgnoreCase(name)) {
					sel = actual;
					encontro = true;

				} else {
					actual = actual.getSiguiente();

				}
			}
		}
		return sel;
	}

	public ArrayList<Jugador> retornaJugadores(String nombre) {
		// Seleccion sel = buscarPorNombre(nombre);
		Seleccion sel = buscarEnArbolPorNombre(nombre);
		Jugador actual = sel.getPrimero();
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(actual);
		while (actual != sel.getUltimo()) {
			actual = actual.getSiguiente();
			if (actual != null)
				jugadores.add(actual);
		}

		return jugadores;

	}

	public void serializarSelecciones() {
		file = new File("files/serializado.dat");
		ArrayList<Seleccion> selecciones = new ArrayList<>();
		actual = primero;
		while (actual != null) {
			selecciones.add(actual);
			actual = actual.getSiguiente();
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(selecciones);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void recuperarSelecciones() {
		file = new File("files/serializado.dat");
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				@SuppressWarnings("unchecked")
				ArrayList<Seleccion> selecciones_recuperadas = (ArrayList<Seleccion>) ois.readObject();
				ois.close();
				for (int i = 0; i < selecciones_recuperadas.size(); i++) {
					agregarSeleccion(selecciones_recuperadas.get(i));

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public Seleccion getPrimero() {
		return primero;
	}

	public void setPrimero(Seleccion primero) {
		this.primero = primero;
	}

	public Seleccion getActual() {
		return actual;
	}

	public void setActual(Seleccion actual) {
		this.actual = actual;
	}

	public Seleccion getNodoAnterior() {
		return nodoAnterior;
	}

	public void setNodoAnterior(Seleccion nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	public int getNumeroElementos() {
		return numeroElementos;
	}

	public void setNumeroElementos(int numeroElementos) {
		this.numeroElementos = numeroElementos;
	}

	public Seleccion getRaiz() {
		return raiz;
	}

	public void setRaiz(Seleccion raiz) {
		this.raiz = raiz;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

}
