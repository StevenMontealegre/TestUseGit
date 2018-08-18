package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mundo.Jugador;
import mundo.Seleccion;

public class PanelInfoJugador extends JPanel implements ActionListener {

	private JTextField txtNombreJugador, txtNombre, txtPosicion, txtPuntajeFifa, txtEdad, txtAltura;
	private JLabel lbNombre, lbPosicion, lbPuntajeFifa, lbEdad, lbAltura, lbImagen;
	private JButton btnAnterior, btnSiguiente, btnPrimero;
	public final static String ANTERIOR = "anterior";
	public final static String SIGUIENTE = "siguiente";
	public final static String PRIMERO = "primero";
	private InterfazPrincipal principal;

	public PanelInfoJugador(InterfazPrincipal p) {
		// TODO Auto-generated constructor stub

		principal = p;
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtPosicion = new JTextField();
		txtPosicion.setEditable(false);
		txtPuntajeFifa = new JTextField();
		txtPuntajeFifa.setEditable(false);
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtAltura = new JTextField();
		txtAltura.setEditable(false);
		txtNombreJugador = new JTextField();
		txtNombreJugador.setEditable(false);
		txtNombreJugador.setText("Radamel Falcao");

		lbNombre = new JLabel("Nombre: ");
		lbPosicion = new JLabel("Posicion: ");
		lbPuntajeFifa = new JLabel("Puntaje FIFA: ");
		lbEdad = new JLabel("Fecha de nacimiento: ");
		lbAltura = new JLabel("Altura: ");
		lbImagen = new JLabel();
		ImageIcon icon = new ImageIcon("images/falcao.jpg");
		Icon icono = new ImageIcon(icon.getImage());
		lbImagen.setIcon(icono);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setActionCommand(ANTERIOR);
		btnAnterior.addActionListener(this);
		btnPrimero = new JButton("Primero");
		btnPrimero.setActionCommand(PRIMERO);
		btnPrimero.addActionListener(this);
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setActionCommand(SIGUIENTE);
		btnSiguiente.addActionListener(this);

		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Jugador:"));
		setBackground(Color.RED);
		JPanel panelAux1 = new JPanel();
		panelAux1.setLayout(new GridLayout());
		JLabel lbVacio = new JLabel();
		panelAux1.add(lbVacio);
		panelAux1.add(lbImagen);
		JPanel panelAux2 = new JPanel();
		panelAux2.setLayout(new GridLayout(5, 2));
		panelAux2.add(lbNombre);
		panelAux2.add(txtNombre);
		panelAux2.add(lbPosicion);
		panelAux2.add(txtPosicion);
		panelAux2.add(lbPuntajeFifa);
		panelAux2.add(txtPuntajeFifa);
		panelAux2.add(lbEdad);
		panelAux2.add(txtEdad);
		panelAux2.add(lbAltura);
		panelAux2.add(txtAltura);
		JPanel panelAux3 = new JPanel();
		panelAux3.setLayout(new GridLayout(1, 3));
		panelAux3.add(btnAnterior);
		panelAux3.add(btnPrimero);
		panelAux3.add(btnSiguiente);

		add(panelAux1, BorderLayout.NORTH);
		add(panelAux2, BorderLayout.CENTER);
		add(panelAux3, BorderLayout.SOUTH);

	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	public JLabel getLbNombre() {
		return lbNombre;
	}

	public void setLbNombre(JLabel lbNombre) {
		this.lbNombre = lbNombre;
	}

	public JLabel getLbPosicion() {
		return lbPosicion;
	}

	public void setLbPosicion(JLabel lbPosicion) {
		this.lbPosicion = lbPosicion;
	}

	public JLabel getLbPuntajeFifa() {
		return lbPuntajeFifa;
	}

	public void setLbPuntajeFifa(JLabel lbPuntajeFifa) {
		this.lbPuntajeFifa = lbPuntajeFifa;
	}

	public JLabel getLbEdad() {
		return lbEdad;
	}

	public void setLbEdad(JLabel lbEdad) {
		this.lbEdad = lbEdad;
	}

	public JLabel getLbAltura() {
		return lbAltura;
	}

	public void setLbAltura(JLabel lbAltura) {
		this.lbAltura = lbAltura;
	}

	public JLabel getLbImagen() {
		return lbImagen;
	}

	public void setLbImagen(JLabel lbImagen) {
		this.lbImagen = lbImagen;
	}

	public JTextField getTxtNombreJugador() {
		return txtNombreJugador;
	}

	public void setTxtNombreJugador(JTextField txtNombreJugador) {
		this.txtNombreJugador = txtNombreJugador;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtPosicion() {
		return txtPosicion;
	}

	public void setTxtPosicion(JTextField txtPosicion) {
		this.txtPosicion = txtPosicion;
	}

	public JTextField getTxtPuntajeFifa() {
		return txtPuntajeFifa;
	}

	public void setTxtPuntajeFifa(JTextField txtPuntajeFifa) {
		this.txtPuntajeFifa = txtPuntajeFifa;
	}

	public JTextField getTxtFechaNacimiento() {
		return txtEdad;
	}

	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtEdad = txtFechaNacimiento;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(JTextField txtAltura) {
		this.txtAltura = txtAltura;
	}

	public InterfazPrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(InterfazPrincipal principal) {
		this.principal = principal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(SIGUIENTE)) {

			Seleccion seleccion = principal.getModelo()
					.buscarEnArbolPorNombre(principal.getPanelSelecciones().getTxtVariableSeleccion().getText());
			seleccion.recorrerADerecha();
			Jugador jug = seleccion.getActual();
			this.getTxtNombre().setText(jug.getNombre());
			this.getTxtPosicion().setText(jug.getPosicion());
			this.getTxtPuntajeFifa().setText(jug.getPuntajeFifa() + "");
			this.getTxtFechaNacimiento().setText(jug.getEdad() + "");
			this.getTxtAltura().setText(jug.getAltura() + "");
			ImageIcon icon = new ImageIcon(jug.getRutaImagen());
			Icon icono = new ImageIcon(icon.getImage());
			this.getLbImagen().setIcon(icono);

		}

		if (comando.equalsIgnoreCase(PRIMERO)) {
			Seleccion seleccion = principal.getModelo()
					.buscarEnArbolPorNombre(principal.getPanelSelecciones().getTxtVariableSeleccion().getText());
			Jugador jug = seleccion.getPrimero();
			seleccion.setActual(jug);
			this.getTxtNombre().setText(jug.getNombre());
			this.getTxtPosicion().setText(jug.getPosicion());
			this.getTxtPuntajeFifa().setText(jug.getPuntajeFifa() + "");
			this.getTxtFechaNacimiento().setText(jug.getEdad() + "");
			this.getTxtAltura().setText(jug.getAltura() + "");
			ImageIcon icon = new ImageIcon(jug.getRutaImagen());
			Icon icono = new ImageIcon(icon.getImage());
			this.getLbImagen().setIcon(icono);

		}
		if (comando.equalsIgnoreCase(ANTERIOR)) {
			Seleccion seleccion = principal.getModelo()
					.buscarEnArbolPorNombre(principal.getPanelSelecciones().getTxtVariableSeleccion().getText());
			seleccion.recorrerAIzquierda();
			Jugador jug = seleccion.getActual();
			this.getTxtNombre().setText(jug.getNombre());
			this.getTxtPosicion().setText(jug.getPosicion());
			this.getTxtPuntajeFifa().setText(jug.getPuntajeFifa() + "");
			this.getTxtFechaNacimiento().setText(jug.getEdad() + "");
			this.getTxtAltura().setText(jug.getAltura() + "");
			ImageIcon icon = new ImageIcon(jug.getRutaImagen());
			Icon icono = new ImageIcon(icon.getImage());
			this.getLbImagen().setIcon(icono);

		}
	}

}
