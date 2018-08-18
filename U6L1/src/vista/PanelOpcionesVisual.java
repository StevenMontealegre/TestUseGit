package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpcionesVisual extends JPanel implements ActionListener {
	private JButton btnRanking, btnTorneo, btnAleatorio;
	public final static String RANKING = "ranking";
	public final static String TORNEO = "torneo";
	public final static String ALEATORIO = "aleatorio";
	private InterfazPrincipal principal;

	public PanelOpcionesVisual(InterfazPrincipal p) {
		// TODO Auto-generated constructor stub

		principal = p;
		btnRanking = new JButton("Ranking");
		btnTorneo = new JButton("Torneo");
		btnAleatorio = new JButton("Ramdon");
		btnRanking.addActionListener(this);
		btnRanking.setActionCommand(RANKING);
		btnTorneo.addActionListener(this);
		btnTorneo.setActionCommand(TORNEO);
		btnAleatorio.addActionListener(this);
		btnAleatorio.setActionCommand(ALEATORIO);
		setLayout(new GridLayout(1, 3));
		add(btnRanking);
		add(btnTorneo);
		add(btnAleatorio);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
