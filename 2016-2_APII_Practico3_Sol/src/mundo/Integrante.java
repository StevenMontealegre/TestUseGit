package mundo;

import java.util.ArrayList;

public class Integrante{
	private String nombre;
	private int edad;
	
	private Integrante izq;
	private Integrante der;
	private Integrante padre;
	
	public Integrante(String nom, int e){
		nombre = nom;
		edad = e;
	}
	
	public String darNombre(){
		return nombre;
	}
	
	public int darEdad(){
		return edad;
	}
	
	public Integrante darIzq(){
		return izq;
	}
	
	public Integrante darDer(){
		return der;
	}
	
	public Integrante darPadre(){
		return padre;
	}
	
	public void cambiarIzq(Integrante izquierda){
		izq = izquierda;
	}
	
	public void cambiarDer(Integrante derecha){
		der = derecha;
	}
	
	public void cambiarPadre(Integrante p){
		padre = p;
	}
	
	public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
	    if(der!=null) {
	        der.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
	    }
	    sb.append(prefix).append(isTail ? "└── " : "┌── ").append(nombre+"("+edad+")").append("\n");
	    if(izq!=null) {
	        izq.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
	    }
	    return sb;
	}

	@Override
	public String toString() {
	    return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
	}
	
	public String print() {
        return print("", true);
    }

    private String print(String prefix, boolean isTail) {
        String cad = prefix + (isTail ? "└── " : "├── ") + nombre+"("+edad+")\n";
        
        ArrayList<Integrante> children = new ArrayList<>();
        if(der!=null) children.add(der);
        if(izq!=null) children.add(izq);
        
        for (int i = 0; i < children.size() - 1; i++) {
            cad += children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            cad += children.get(children.size() - 1)
                    .print(prefix + (isTail ?"    " : "│   "), true);
        }
        return cad;
    }	
}
