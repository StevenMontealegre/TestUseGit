package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelVisualizacion extends JPanel{
	private JTextArea areaVista1;
	private JTextArea areaVista2;
	public PanelVisualizacion(){
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Visualización"));
		
		areaVista1 = new JTextArea();
		areaVista1.setEditable(false);
		areaVista1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		areaVista2 = new JTextArea();
		areaVista2.setEditable(false);
		areaVista2.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		JTabbedPane pestanas = new JTabbedPane();		
		pestanas.add("Vista 1", new JScrollPane(areaVista1));
		pestanas.add("Vista 2", new JScrollPane(areaVista2));
		
		add(pestanas, BorderLayout.CENTER);
		
	}
	
	public void cambiarVista1(String arbolTxt){
		areaVista1.setText(arbolTxt);
	}
	
	public void cambiarVista2(String arbolTxt){
		areaVista2.setText(arbolTxt);
	}
}
