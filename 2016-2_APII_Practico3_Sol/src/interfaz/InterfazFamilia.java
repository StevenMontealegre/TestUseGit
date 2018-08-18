package interfaz;

import java.awt.BorderLayout;
import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mundo.Familia;
import mundo.Integrante;

@SuppressWarnings("serial")
public class InterfazFamilia extends JFrame{
	private Familia miFamilia;
	private PanelNuevoIntegrante panelNuevoIntegrante;
	private PanelVisualizacion panelVisualizacion;
	private PanelOpciones panelOpciones;
	public InterfazFamilia(){
		setLayout(new BorderLayout());
		setTitle("Disposición para la Foto Familiar :: Árbol Familiar =)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		miFamilia = new Familia();
		panelNuevoIntegrante = new PanelNuevoIntegrante(this);
		panelVisualizacion = new PanelVisualizacion();
		panelOpciones= new PanelOpciones(this);
		
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new BorderLayout());
		panelAux.add(panelNuevoIntegrante, BorderLayout.CENTER);
		panelAux.add(panelOpciones, BorderLayout.SOUTH);
		
		add(new JLabel(new ImageIcon("img/bannerTeatrino.png")), BorderLayout.NORTH);
		add(panelVisualizacion, BorderLayout.CENTER);
		add(panelAux, BorderLayout.SOUTH);
		pack();
		setSize(getWidth(),getHeight()+150);
		refrescarVistaArbol();
	}
	
	public void agregarIntegrante(){
		String nombre = panelNuevoIntegrante.darNombre();
		String edadStr = panelNuevoIntegrante.darEdad();
		try{
			int edad = Integer.parseInt(edadStr);
			miFamilia.agregarIntegrante(nombre, edad);
			refrescarVistaArbol();
			JOptionPane.showMessageDialog(this, "El nuevo integrante fue agregado satisfactoriamente.");
		}catch(NumberFormatException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.");
		}
	}
	
	public void refrescarVistaArbol(){
		panelVisualizacion.cambiarVista1(miFamilia.toString());
		panelVisualizacion.cambiarVista2(miFamilia.print());		
	}
	
	public static void main(String[] args){
		InterfazFamilia ventana;
		ventana = new InterfazFamilia();
		ventana.setVisible(true);
	}

	public void listarMayoresEdad() {
		ArrayList<Integrante> lista = miFamilia.listarMayoresDeEdad();
		String list = "";
		for (int i = 0; i < lista.size(); i++) {
			list+=lista.get(i).darNombre()+" edad:"+lista.get(i).darEdad()+"\n";
		}
		JOptionPane.showMessageDialog(this, "Los integrantes de la familia que son mayores de edad son:\n"+list);
	}

	public void encontrarEscalon() {
		String nombre = JOptionPane.showInputDialog("Ingrese Nombre");
		int n = miFamilia.encontrarEscalonOlvidadizo(nombre);
		JOptionPane.showMessageDialog(null, "Nivel: " + n);
	}

	public void indicarCaminoAPuesto() {
		String nombre = JOptionPane.showInputDialog("Ingrese Nombre");
		String n = miFamilia.indicarCaminoAPuesto(nombre);
		JOptionPane.showMessageDialog(null, "Ruta: " + n);
	}

	public void calcularTotalEdadSubarol() {
		String nombre = JOptionPane.showInputDialog("Ingrese Nombre");
		int n = miFamilia.totalEdadesSubArbolConRaizEn(nombre);
		JOptionPane.showMessageDialog(null, "Suma edades árbol: " + n);
	}
}
