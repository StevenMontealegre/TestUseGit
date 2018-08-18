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
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import mundo.Seleccion;

public class PanelAgregarSeleccion extends JDialog implements ActionListener {

	private JTextField txtPais, txtPuntos, txtPromedioAltura, txtPromedioEdad, txtPromedioFifa, txtImagen, txtBandera,
			txtNombreSeleccion;
	private JLabel lbPais, lbPuntos, lbPromedioAltura, lbPromedioEdad, lbPromedioFifa, lbImagen, lbBandera;
	private JButton btnGuardar, btnImagen, btnBandera;
	private String ruta_imagen;
	public final static String GUARDAR = "guardar";
	public final static String IMAGEN = "imagen";
	public final static String BANDERA = "bandera";
	private InterfazPrincipal principal;

	public PanelAgregarSeleccion(InterfazPrincipal p) {
		// TODO Auto-generated constructor stub

		principal = p;
		txtPais = new JTextField();
		txtPuntos = new JTextField();
		txtPromedioAltura = new JTextField();
		txtPromedioAltura.setEditable(false);
		txtPromedioEdad = new JTextField();
		txtPromedioEdad.setEditable(false);
		txtPromedioFifa = new JTextField();
		txtPromedioFifa.setEditable(false);
		txtBandera = new JTextField();
		txtBandera.setEditable(false);
		txtImagen = new JTextField();
		txtNombreSeleccion = new JTextField();

		lbPais = new JLabel("Pais: ");
		lbPuntos = new JLabel("Puntos: ");
		lbPromedioEdad = new JLabel("Promedio edad: ");
		lbPromedioAltura = new JLabel("Promedio altura: ");
		lbPromedioFifa = new JLabel("Promedio FIFA: ");
		lbImagen = new JLabel();
		lbBandera = new JLabel("Ruta bandera: ");

		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand(GUARDAR);
		btnGuardar.addActionListener(this);
		btnImagen = new JButton("Imagen");
		btnImagen.setActionCommand(IMAGEN);
		btnImagen.addActionListener(this);
		btnBandera = new JButton("Bandera");
		btnBandera.setActionCommand(BANDERA);
		btnBandera.addActionListener(this);

		ruta_imagen = "";

		setLayout(new GridLayout(1, 2));
		setTitle("Selecciones copa mundial de la FIFA");

		JPanel panelAux1 = new JPanel();
		panelAux1.setLayout(new GridLayout(7, 2));
		panelAux1.add(lbPais);
		panelAux1.add(txtPais);
		panelAux1.add(lbPuntos);
		panelAux1.add(txtPuntos);
		panelAux1.add(lbBandera);
		panelAux1.add(txtBandera);
		panelAux1.add(lbPromedioAltura);
		panelAux1.add(txtPromedioAltura);
		panelAux1.add(lbPromedioEdad);
		panelAux1.add(txtPromedioEdad);
		panelAux1.add(lbPromedioFifa);
		panelAux1.add(txtPromedioFifa);
		panelAux1.add(btnGuardar);
		panelAux1.add(btnImagen);

		JPanel panelAux2 = new JPanel();
		panelAux2.setLayout(new BorderLayout());
		panelAux2.add(lbImagen, BorderLayout.CENTER);
		panelAux2.add(btnBandera, BorderLayout.SOUTH);
		panelAux2.setBorder(new TitledBorder("Seleccionado:"));

		add(panelAux2);
		add(panelAux1);
		setSize(520, 250);

	}

	public void abrirFicheros() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes JPG y PNG", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(principal);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// lbImagen = new JLabel();
			ImageIcon icon = new ImageIcon("images/" + chooser.getSelectedFile().getName());
			Icon icono = new ImageIcon(icon.getImage());
			lbImagen.setIcon(icono);
			ruta_imagen = "images/" + chooser.getSelectedFile().getName();
			System.out.println("Elegiste abrir este archivo:" + chooser.getSelectedFile().getName());
		}
	}

	public void abrirFicherosBanderas() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes JPG y PNG", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(principal);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// lbImagen = new JLabel();
			// ImageIcon icon = new ImageIcon("flats/" +
			// chooser.getSelectedFile().getName());
			// Icon icono = new ImageIcon(icon.getImage());
			// lbBandera.setIcon(icono);
			txtBandera.setText("flats/" + chooser.getSelectedFile().getName());
			System.out.println("Elegiste abrir este archivo:" + chooser.getSelectedFile().getName());
		}
	}

	public void refrescarCampos() {
		txtPais.setText("");
		txtPuntos.setText("");
		txtPromedioAltura.setText("");
		txtBandera.setText("");
		txtPromedioEdad.setText("");
		txtPromedioFifa.setText("");
		txtImagen.setText("");
		lbImagen.setIcon(null);

	}

	public String darPais() {
		return txtPais.getText();
	}

	public double darPuntos() {
		String p = txtPuntos.getText();
		double ptos = Double.parseDouble(p);
		return ptos;
	}

	public String darBandera() {
		return txtBandera.getText();
	}

	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(IMAGEN)) {
			abrirFicheros();
		}
		if (comando.equalsIgnoreCase(GUARDAR)) {

			Seleccion sel = new Seleccion(darPais(), darPuntos(), getRuta_imagen(), darBandera());
			txtNombreSeleccion.setText(darPais());
			this.repaint();
			System.out.println(txtNombreSeleccion.getText());
			principal.getModelo().agregarArbolSeleccion(sel);
			// principal.getModelo().agregarSeleccion(sel);
			principal.getPanelSelecciones().agregarSeleccionALista(sel);
			// principal.getModelo().serializarSelecciones();
			refrescarCampos();
			this.setVisible(false);

		}
		if (comando.equalsIgnoreCase(BANDERA)) {
			abrirFicherosBanderas();
		}

	}

	public JTextField getTxtPais() {
		return txtPais;
	}

	public void setTxtPais(JTextField txtPais) {
		this.txtPais = txtPais;
	}

	public JTextField getTxtPuntos() {
		return txtPuntos;
	}

	public void setTxtPuntos(JTextField txtPuntos) {
		this.txtPuntos = txtPuntos;
	}

	public JTextField getTxtPromedioAltura() {
		return txtPromedioAltura;
	}

	public void setTxtPromedioAltura(JTextField txtPromedioAltura) {
		this.txtPromedioAltura = txtPromedioAltura;
	}

	public JTextField getTxtPromedioEdad() {
		return txtPromedioEdad;
	}

	public void setTxtPromedioEdad(JTextField txtPromedioEdad) {
		this.txtPromedioEdad = txtPromedioEdad;
	}

	public JTextField getTxtPromedioFifa() {
		return txtPromedioFifa;
	}

	public void setTxtPromedioFifa(JTextField txtPromedioFifa) {
		this.txtPromedioFifa = txtPromedioFifa;
	}

	public JTextField getTxtImagen() {
		return txtImagen;
	}

	public void setTxtImagen(JTextField txtImagen) {
		this.txtImagen = txtImagen;
	}

	public JTextField getTxtNombreSeleccion() {
		return txtNombreSeleccion;
	}

	public void setTxtNombreSeleccion(JTextField txtNombreSeleccion) {
		this.txtNombreSeleccion = txtNombreSeleccion;
	}

	public JLabel getLbPais() {
		return lbPais;
	}

	public void setLbPais(JLabel lbPais) {
		this.lbPais = lbPais;
	}

	public JLabel getLbPuntos() {
		return lbPuntos;
	}

	public void setLbPuntos(JLabel lbPuntos) {
		this.lbPuntos = lbPuntos;
	}

	public JLabel getLbPromedioAltura() {
		return lbPromedioAltura;
	}

	public void setLbPromedioAltura(JLabel lbPromedioAltura) {
		this.lbPromedioAltura = lbPromedioAltura;
	}

	public JLabel getLbPromedioEdad() {
		return lbPromedioEdad;
	}

	public void setLbPromedioEdad(JLabel lbPromedioEdad) {
		this.lbPromedioEdad = lbPromedioEdad;
	}

	public JLabel getLbPromedioFifa() {
		return lbPromedioFifa;
	}

	public void setLbPromedioFifa(JLabel lbPromedioFifa) {
		this.lbPromedioFifa = lbPromedioFifa;
	}

	public JLabel getLbImagen() {
		return lbImagen;
	}

	public void setLbImagen(JLabel lbImagen) {
		this.lbImagen = lbImagen;
	}

	public InterfazPrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(InterfazPrincipal principal) {
		this.principal = principal;
	}

}
