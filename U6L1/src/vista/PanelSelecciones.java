
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mundo.Jugador;
import mundo.Seleccion;

public class PanelSelecciones extends JPanel implements ActionListener, ListSelectionListener {
	private JButton btnAgregar, btnEliminar, btnBuscar, btnModificar, btnVisualizar;
	private JTextField txtVariableSeleccion;
	public final static String AGREGAR = "agregar";
	public final static String ELIMINAR = "eliminar";
	public final static String BUSCAR = "buscar";
	public final static String MODIFICAR = "modificar";
	public final static String VISUALIZAR = "visualizar";

	private JList<Seleccion> listaSelecciones;
	private DefaultListModel<Seleccion> modelo;
	private JScrollPane scroll;
	private InterfazPrincipal principal;

	public PanelSelecciones(InterfazPrincipal p) {
		// TODO Auto-generated constructor stub

		principal = p;
		JList<Seleccion> listaSelecciones = new JList<>();
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setActionCommand(BUSCAR);
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand(MODIFICAR);
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(this);
		btnVisualizar.setActionCommand(VISUALIZAR);
		txtVariableSeleccion = new JTextField();

		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Selecciones"));
		setBackground(Color.BLUE);
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new GridLayout(1, 5));
		panelAux.add(btnAgregar);
		panelAux.add(btnEliminar);
		panelAux.add(btnBuscar);
		panelAux.add(btnModificar);
		panelAux.add(btnVisualizar);

		// inicialización lista

		modelo = new DefaultListModel<Seleccion>();
		listaSelecciones = new JList<>(modelo);
		listaSelecciones.addListSelectionListener(this);
		listaSelecciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll = new JScrollPane(listaSelecciones);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(130, 100));
		scroll.setEnabled(true);

		add(scroll, BorderLayout.CENTER);
		add(panelAux, BorderLayout.SOUTH);

	}

	public void agregarSeleccionALista(Seleccion sel) {
		modelo.addElement(sel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(AGREGAR)) {
			principal.mostrarPanelAgregarSeleccion();
		}
		if (comando.equalsIgnoreCase(BUSCAR)) {
			String no = JOptionPane.showInputDialog("Ingrese el nombre de la selección que desea buscar");
			JOptionPane.showMessageDialog(null,
					"La selección que buscas es: " + principal.getModelo().buscarPorNombre(no));

		}
		if (comando.equalsIgnoreCase(MODIFICAR)) {
			Seleccion sel = principal.getModelo().buscarEnArbolPorNombre(txtVariableSeleccion.getText());
			String nom = sel.getNombre();
			double pun = sel.getPuntos();
			String rut = sel.getRutaImagen();
			principal.getPanelAgregarSel().getTxtPais().setText(nom);
			principal.getPanelAgregarSel().getTxtPuntos().setText(pun + "");
			ImageIcon icon = new ImageIcon(rut);
			Icon icono = new ImageIcon(icon.getImage());
			principal.getPanelAgregarSel().getLbImagen().setIcon(icono);
			principal.getPanelAgregarSel().getLbImagen();
			principal.mostrarPanelAgregarSeleccion();
		}
		if (comando.equalsIgnoreCase(VISUALIZAR)) {
			principal.mostrarPanelVisualizar();
			principal.getModelo().recorrerInOrden(principal.getModelo().getRaiz());
			

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

		JList lista = (JList) e.getSource();
		Seleccion sel = (Seleccion) lista.getSelectedValue();

		if (sel != null) {
			txtVariableSeleccion.setText(sel.getNombre());
			System.out.println(txtVariableSeleccion.getText());
			refrescarLista();
		}

	}

	public void refrescarLista() {
		principal.getPanelJugadores().refrescarListaJugadores();
	}

	// deserializar
	public void refrescarLista2() {
		principal.getPanelJugadores().refrescarListaJugadores2();
	}

	public JTextField getTxtVariableSeleccion() {
		return txtVariableSeleccion;
	}

	public void setTxtVariableSeleccion(JTextField txtVariableSeleccion) {
		this.txtVariableSeleccion = txtVariableSeleccion;
	}

}
