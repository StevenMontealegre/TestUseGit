package interfaz;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener{
	
	private JButton butListaMayoresEdad;
	public final static String MAYORES_EDAD = "MAYORES_EDAD";
	
	private JButton butEncontrarEscalon;
	public final static String ENCONTRAR_ESCALON = "ENCONTRAR_ESCALON";
	
	private JButton butIndicarCaminoAPuesto;
	public final static String CAMINO_PUESTO = "CAMINO_PUESTO";
	
	private JButton butTotalEdadesSubarbol;
	public final static String TOTAL_SUBARBOL = "TOTAL_SUBARBOL";
	
	private InterfazFamilia principal;
	
	public PanelOpciones(InterfazFamilia ventana) {
		principal = ventana;
		
		setBorder(new TitledBorder("Opciones"));
		setLayout(new FlowLayout());
		
		butListaMayoresEdad = new JButton("Mayores Edad");
		butListaMayoresEdad.addActionListener(this);
		butListaMayoresEdad.setActionCommand(MAYORES_EDAD);
		butListaMayoresEdad.setMargin(new Insets(0,0,0,0));
		
		butEncontrarEscalon = new JButton("Encontrar Escalón");
		butEncontrarEscalon.addActionListener(this);
		butEncontrarEscalon.setActionCommand(ENCONTRAR_ESCALON);
		butEncontrarEscalon.setMargin(new Insets(0,0,0,0));
		
		butIndicarCaminoAPuesto = new JButton("Camino a Puesto");
		butIndicarCaminoAPuesto.addActionListener(this);
		butIndicarCaminoAPuesto.setActionCommand(CAMINO_PUESTO);
		butIndicarCaminoAPuesto.setMargin(new Insets(0,0,0,0));
		
		butTotalEdadesSubarbol = new JButton("Total Subárbol");
		butTotalEdadesSubarbol.addActionListener(this);
		butTotalEdadesSubarbol.setActionCommand(TOTAL_SUBARBOL);
		butTotalEdadesSubarbol.setMargin(new Insets(0,0,0,0));
		
		add(butListaMayoresEdad);
		add(butEncontrarEscalon);
		add(butIndicarCaminoAPuesto);
		add(butTotalEdadesSubarbol);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(MAYORES_EDAD)){
			principal.listarMayoresEdad();
		}else if(comando.equals(ENCONTRAR_ESCALON)){
			principal.encontrarEscalon();
		}else if(comando.equals(CAMINO_PUESTO)){
			principal.indicarCaminoAPuesto();
		}else if(comando.equals(TOTAL_SUBARBOL)){
			principal.calcularTotalEdadSubarol();
		}
	}	
}
