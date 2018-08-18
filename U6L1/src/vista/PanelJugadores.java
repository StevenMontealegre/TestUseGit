package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mundo.Jugador;
import mundo.Seleccion;

public class PanelJugadores extends JPanel implements ActionListener, ListSelectionListener {
	private JButton btnAgregar, btnEliminar, btnBuscar, btnGuardar;
	public final static String AGREGAR = "agregar";
	public final static String ELIMINAR = "eliminar";
	public final static String BUSCAR = "buscar";
	public final static String GUARDAR = "guardar";
	private JList<Jugador> listaJugadores;
	private DefaultListModel<Jugador> modelo;
	private JScrollPane scroll;
	private InterfazPrincipal principal;

	public PanelJugadores(InterfazPrincipal p) {
		// TODO Auto-generated constructor stub
		principal = p;
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setActionCommand(BUSCAR);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand(GUARDAR);

		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Jugadores"));
		setBackground(Color.WHITE);
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new GridLayout(1, 4));
		panelAux.add(btnAgregar);
		panelAux.add(btnEliminar);
		panelAux.add(btnBuscar);
		panelAux.add(btnGuardar);

		// inicialización lista

		modelo = new DefaultListModel<Jugador>();
		listaJugadores = new JList<>(modelo);
		listaJugadores.addListSelectionListener(this);
		listaJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scroll = new JScrollPane(listaJugadores);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(130, 100));
		scroll.setEnabled(true);

		add(scroll, BorderLayout.CENTER);
		add(panelAux, BorderLayout.SOUTH);
	}

	public void agregarJugadorALista(Jugador jug) {
		modelo.addElement(jug);
	}

	public void refrescarListaJugadores() {
		modelo.clear();
		ArrayList<Jugador> j = principal.getModelo()
				.retornaJugadores(principal.getPanelSelecciones().getTxtVariableSeleccion().getText());
		for (int i = 0; i < j.size(); i++) {
			principal.getPanelJugadores().agregarJugadorALista(j.get(i));
		}
	}

	// deserialzar
	public void refrescarListaJugadores2() {
		// modelo.clear();
		Seleccion seleccion = principal.getModelo().getPrimero();
		while (seleccion != null) {
			ArrayList<Jugador> j = principal.getModelo()
					.retornaJugadores(principal.getPanelSelecciones().getTxtVariableSeleccion().getText());
			for (int i = 0; i < j.size(); i++) {
				principal.getPanelJugadores().agregarJugadorALista(j.get(i));
			}
			seleccion = seleccion.getSiguiente();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(AGREGAR)) {
			principal.mostrarPanelAgregarJugador();
		}

		if (comando.equalsIgnoreCase(ELIMINAR)) {

			Seleccion sel = principal.getModelo()
					.buscarPorNombre(principal.getPanelSelecciones().getTxtVariableSeleccion().getText());
			String nom = JOptionPane.showInputDialog("Ingrese el nombre del jugador a eliminar");
			sel.eliminarJugador(nom);
			refrescarListaJugadores();
			if (sel.buscarPorNombre(nom) == null) {
				JOptionPane.showMessageDialog(null, "El jugador ha sido eliminado satisfactoriamente");
			}

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

		JList lista = (JList) e.getSource();
		Jugador jug = (Jugador) lista.getSelectedValue();

		// Aquí es donde cambio el actual por el que seleccione
		principal.getModelo().getActual().setActual(jug);
		if (jug != null) {

			principal.getPanelInfo().getTxtNombre().setText(jug.getNombre());
			principal.getPanelInfo().getTxtPosicion().setText(jug.getPosicion());
			principal.getPanelInfo().getTxtPuntajeFifa().setText(jug.getPuntajeFifa() + "");
			principal.getPanelInfo().getTxtFechaNacimiento().setText(jug.getEdad() + "");
			principal.getPanelInfo().getTxtAltura().setText(jug.getAltura() + "");
			ImageIcon icon = new ImageIcon(jug.getRutaImagen());
			Icon icono = new ImageIcon(icon.getImage());
			principal.getPanelInfo().getLbImagen().setIcon(icono);
		}

	}

}
