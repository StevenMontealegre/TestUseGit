package mundo;

import java.util.ArrayList;

public class Familia {
	private Integrante madre;

	public Familia() {
		inicializar();
	}
	
	public void inicializar(){
		agregarIntegrante("a", 20);
		agregarIntegrante("b", 30);
		agregarIntegrante("c", 35);
		agregarIntegrante("d", 25);
		agregarIntegrante("e", 15);
		agregarIntegrante("f", 5);
		agregarIntegrante("g", 18);
		agregarIntegrante("h", 28);
	}
	
	public void agregarIntegrante(String nom, int ed) {
		Integrante nuevo = new Integrante(nom, ed);
		if (madre == null) {
			madre = nuevo;
		} else {
			boolean agrego = false;
			Integrante actual = madre;
			while (!agrego) {
				if (actual.darEdad() < nuevo.darEdad()) {
					if (actual.darDer() == null) {
						actual.cambiarDer(nuevo);
						nuevo.cambiarPadre(actual);
						agrego = true;
					} else {
						actual = actual.darDer();
					}
				} else {
					if (actual.darIzq() == null) {
						actual.cambiarIzq(nuevo);
						nuevo.cambiarPadre(actual);
						agrego = true;
					} else {
						actual = actual.darIzq();
					}
				}
			}
		}
	}

	// ********************************************************************************
	// Punto 1.
	// ********************************************************************************
	public ArrayList<Integrante> listarMayoresDeEdad() {
		ArrayList<Integrante> lista = new ArrayList<Integrante>();
		addIntegrantes(madre, lista);
		return lista;
	}

	public void addIntegrantes(Integrante actual, ArrayList<Integrante> lista) {
		if (actual == null)
			return;
		addIntegrantes(actual.darIzq(), lista);
		if (actual.darEdad() > 17)
			lista.add(actual);
		addIntegrantes(actual.darDer(), lista);
	}

	// ********************************************************************************
	// Punto 2.
	// ********************************************************************************
	public int encontrarEscalonOlvidadizo(String nombrePersona) {
		int escalon = -1;
		if (madre != null)
			escalon = econtrarEscalon(madre, nombrePersona, 0);
		return escalon;
	}

	public int econtrarEscalon(Integrante actual, String nombre, int acum) {
		if (actual == null)
			return -1;
		else if (actual.darNombre().equals(nombre))
			return acum;
		else {
			int nivelIzq = econtrarEscalon(actual.darIzq(), nombre, acum + 1);
			int nivelDer = econtrarEscalon(actual.darDer(), nombre, acum + 1);
			if (nivelIzq == -1 && nivelDer == -1)
				return -1;
			else if (nivelIzq == -1)
				return nivelDer;
			else
				return nivelIzq;
		}
	}

	// ********************************************************************************
	// Punto 3.
	// ********************************************************************************
	public String indicarCaminoAPuesto(String nombrePersona) {
		if (madre != null) {
			Integrante i = buscarIntegrante(nombrePersona, madre);
			if (i==null) return "No existe.";
			return CaminoAPuesto(i.darEdad(), madre);
		} else
			return "";
	}
	
	public String CaminoAPuesto(int edad, Integrante actual) {
		String camino = "";
		if (actual.darEdad() < edad)
			camino += "der-"+CaminoAPuesto(edad, actual.darDer());
		else if(actual.darEdad() > edad)
			camino += "izq-"+CaminoAPuesto(edad, actual.darIzq());
		
		return camino;
	}
	
	public Integrante buscarIntegrante(String nombrePersona, Integrante actual) {
		Integrante integrante = null;
		if(actual != null){
			if (actual.darNombre().equals(nombrePersona))
				integrante = actual;
			else {
				integrante = (buscarIntegrante(nombrePersona, actual.darIzq()) != null)
						? buscarIntegrante(nombrePersona, actual.darIzq())
						: buscarIntegrante(nombrePersona, actual.darDer());
			}
		}
		return integrante;
	}

	// ********************************************************************************
	// Punto 4.
	// ********************************************************************************
	public int totalEdadesSubArbolConRaizEn(String nombrePersona){
		Integrante i = buscarIntegrante(nombrePersona, madre);
		if (i==null) return 0;
		int suma = sumaEdadesSubArbol(i);
		return suma;
	}
	
	public int sumaEdadesSubArbol(Integrante actual){
		int suma = 0;
		suma += actual.darEdad();
		if(actual.darIzq()!= null)
			suma += sumaEdadesSubArbol(actual.darIzq());
		if(actual.darDer()!= null)
			suma += sumaEdadesSubArbol(actual.darDer());
		return suma;
		
	}
	
	// ********************************************************************************
	
	public Integrante darMadre() {
		return madre;
	}

	public String toString() {
		if (madre != null) {
			return madre.toString();
		} else {
			return "";
		}
	}

	public String print() {
		if (madre != null) {
			return madre.print();
		} else {
			return "";
		}
	}
}
