package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class PanelVisualizar extends JDialog implements ActionListener {
	private InterfazPrincipal principal;
	private JButton btnRandom;
	private JButton btnRanking;
	public final static String RANDOM = "random";

	public PanelVisualizar(InterfazPrincipal p) {
		// TODO Auto-generated constructor stub
		principal = p;
		setSize(1200, 700);
		setLayout(new BorderLayout());
		btnRandom = new JButton("RANDOM");
		btnRandom.addActionListener(this);
		btnRandom.setActionCommand(RANDOM);
		add(btnRandom, BorderLayout.SOUTH);
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		Graphics2D g2d = (Graphics2D) arg0;
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image alemaniaFlag = tool.getImage("flags/alemania.png");
		Image arabiaFlag = tool.getImage("flags/arabia.jpg");
		Image argentinaFlag = tool.getImage("flags/argentina.jpg");
		Image brasilFlag = tool.getImage("flags/brasil.png");
		Image colombiaFlag = tool.getImage("flags/colombia.png");
		Image españaFlag = tool.getImage("flags/españa.png");
		Image franciaFlag = tool.getImage("flags/francia.png");
		Image japonFlag = tool.getImage("flags/japon.png");
		Image koreaFlag = tool.getImage("flags/korea.png");
		Image mexicoFlag = tool.getImage("flags/mexico.png");
		Image panamaFlag = tool.getImage("flags/panama.png");
		Image peruFlag = tool.getImage("flags/peru.png");
		Image poloniaFlag = tool.getImage("flags/polonia.png");
		Image rusiaFlag = tool.getImage("flags/rusia.png");
		Image senegalFlag = tool.getImage("flags/senegal.png");
		Image uruguayFlag = tool.getImage("flags/uruguay.png");
		g2d.drawImage(alemaniaFlag, 15, 30, null);
		g2d.drawImage(arabiaFlag, 15, 120, null);
		g2d.drawImage(argentinaFlag, 15, 120, null);
		g2d.drawImage(brasilFlag, 15, 210, null);
		g2d.drawImage(colombiaFlag, 15, 300, null);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
