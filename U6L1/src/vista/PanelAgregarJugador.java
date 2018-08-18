package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import mundo.Jugador;

public class PanelAgregarJugador extends JDialog implements ActionListener {

	private JTextField txtNombre, txtPosicion, txtPuntajeFifa, txtEdad, txtAltura, txtImagen;
	private JLabel lbNombre, lbPosicion, lbPuntajeFifa, lbEdad, lbAltura, lbImagen;
	private JButton btnAgregar, btnAgregarImagen;
	public final static String AGREGAR = "agregar";
	public final static String AGREGAR_IMAGEN = "agregarImagen";
	private InterfazPrincipal principal;

	public PanelAgregarJugador(InterfazPrincipal p) {
		// TODO Auto-generated constructor stub

		principal = p;
		txtNombre = new JTextField();
		txtPosicion = new JTextField();
		txtPuntajeFifa = new JTextField();
		txtEdad = new JTextField();
		txtAltura = new JTextField();
		txtImagen = new JTextField();
		txtImagen.setEditable(false);

		lbNombre = new JLabel("Nombre:");
		lbPosicion = new JLabel("Posicion:");
		lbPuntajeFifa = new JLabel("Puntaje FIFA:");
		lbEdad = new JLabel("Edad:");
		lbAltura = new JLabel("Altura:");
		lbImagen = new JLabel("Imagen:");

		btnAgregarImagen = new JButton("Imagen");
		btnAgregarImagen.setActionCommand(AGREGAR_IMAGEN);
		btnAgregarImagen.addActionListener(this);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);

		setLayout(new BorderLayout());
		setSize(400, 200);
		setTitle("Agregar jugador");

		JPanel panelAux1 = new JPanel();
		panelAux1.setLayout(new GridLayout(6, 2));

		panelAux1.add(lbNombre);
		panelAux1.add(txtNombre);
		panelAux1.add(lbPosicion);
		panelAux1.add(txtPosicion);
		panelAux1.add(lbPuntajeFifa);
		panelAux1.add(txtPuntajeFifa);
		panelAux1.add(lbEdad);
		panelAux1.add(txtEdad);
		panelAux1.add(lbAltura);
		panelAux1.add(txtAltura);
		panelAux1.add(lbImagen);
		panelAux1.add(txtImagen);

		JPanel panelAux2 = new JPanel();
		panelAux2.setLayout(new GridLayout(1, 2));
		panelAux2.add(btnAgregar);
		panelAux2.add(btnAgregarImagen);

		add(panelAux1, BorderLayout.CENTER);
		add(panelAux2, BorderLayout.SOUTH);

	}

	public Jugador getDatosJugador() {
		String nom = txtNombre.getText();
		String pos = txtPosicion.getText();
		String pf = txtPuntajeFifa.getText();
		double punFIFA = Double.parseDouble(pf);
		String ed = txtEdad.getText();
		double edad = Double.parseDouble(ed);
		String al = txtAltura.getText();
		double alt = Double.parseDouble(al);
		String rutaIma = txtImagen.getText();

		Jugador jug = new Jugador(nom, pos, punFIFA, edad, alt, rutaIma);

		return jug;

	}

	public void refrescarCampos() {

		txtNombre.setText("");
		txtPosicion.setText("");
		txtPuntajeFifa.setText("");
		txtEdad.setText("");
		txtAltura.setText("");
		txtImagen.setText("");

	}

	public void abrirFicheros() {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes JPG y PNG", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(principal);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// lbImagen = new JLabel();
			// ImageIcon icon = new ImageIcon("images/" +
			// chooser.getSelectedFile().getName());
			// Icon icono = new ImageIcon(icon.getImage());
			// lbImagen.setIcon(icono);
			txtImagen.setText("images/" + chooser.getSelectedFile().getName());
			System.out.println("Elegiste abrir este archivo:" + chooser.getSelectedFile().getName());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(AGREGAR)) {
			principal.agregarJugadorASeleccion();
			refrescarCampos();
			principal.getPanelSelecciones().refrescarLista();
			this.setVisible(false);
		}
		if (comando.equalsIgnoreCase(AGREGAR_IMAGEN)) {
			abrirFicheros();
		}

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

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(JTextField txtAltura) {
		this.txtAltura = txtAltura;
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

	public JButton getBtnSiguiente() {
		return btnAgregar;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnAgregar = btnSiguiente;
	}

	public JButton getBtnAgregarImagen() {
		return btnAgregarImagen;
	}

	public void setBtnAgregarImagen(JButton btnAgregarImagen) {
		this.btnAgregarImagen = btnAgregarImagen;
	}

	public InterfazPrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(InterfazPrincipal principal) {
		this.principal = principal;
	}

	public JTextField getTxtImagen() {
		return txtImagen;
	}

	public void setTxtImagen(JTextField txtImagen) {
		this.txtImagen = txtImagen;
	}

}
