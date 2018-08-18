package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Via {

	private Vehiculo vehiculo;
	public final static String RUTA = "files/certificado";

	public Via() {
		// TODO Auto-generated constructor stub
		vehiculo = new Vehiculo();
	}

	public void generarCertificado() {

		String dato1 = JOptionPane.showInputDialog("ingrese documento");
		String dato2 = JOptionPane.showInputDialog("nombre completo");

		File file = new File(RUTA);
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			pw.println(dato1 + "	" + dato2 + "	" + darDistanciaRecorrida());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Vehiculo darVehiculo() {
		return vehiculo;
	}

	public void detenerVehiculo() {

	}

	public void calcularPuntaje(String a, String b, int c) {
		File file = new File(RUTA);
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			pw.println(a + "	" + b + "	" + c);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int darPuntaje() {
		return vehiculo.darPuntaje();
	}

	public int darDistanciaRecorrida() {
		return vehiculo.darDistanciaRecorrida();
	}

	public boolean estaDetenido() {
		return vehiculo.estaDetenido();
	}
}