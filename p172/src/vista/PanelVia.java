package vista;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.ImageGraphicAttribute;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.*;

public class PanelVia extends JPanel implements MouseListener {

	public final static int INICIO_TOTAL = 200;
	public final static int INICIO_CRUCE = 530;
	public final static int FIN_CRUCE = 590;
	public final static int FIN_TOTAL = 900;
	public final static int LARGO_VIA = 1000;
	private int contador;
	private int distancia;
	public VentanaPruebaTransito principal;

	public PanelVia(VentanaPruebaTransito p) {
		// TODO Auto-generated constructor stub

		principal = p;
		setContador(0);
		this.setDistancia(0);
		setBackground(Color.WHITE);
		addMouseListener(this);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image imagenCarro = tool.getImage("images/scoobydo.png");
		g2d.drawImage(imagenCarro, principal.getModelo().darVehiculo().getPosX(),
				principal.getModelo().darVehiculo().getPosY(), null);
		g2d.drawString("Puntaje:", 10, 10);

		if (principal.getModelo().darVehiculo().estaDetenido() == false) {
			g2d.setColor(Color.WHITE);
			g2d.fillRect(INICIO_TOTAL, 150, FIN_CRUCE, 250);
		}

		g2d.setColor(Color.ORANGE);
		g2d.fillRect(470, 150, 50, 250);

		if (principal.getModelo().darVehiculo().estaDetenido() == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillOval(principal.getModelo().darVehiculo().getPosX() + 80, 280, 20, 20);
			g2d.fillOval(485, 280, 20, 20);
			int x = 485 - (principal.getModelo().darVehiculo().getPosX() + 80);
			distancia = (int) Math.sqrt(x * x);
			principal.getModelo().darVehiculo().setDistanciaRecorrida(distancia);
			g2d.drawLine(485, 290, principal.getModelo().darVehiculo().getPosX() + 80, 290);
			g2d.drawString("Puntaje: " + principal.getModelo().darVehiculo().darDistanciaRecorrida(), 10, 10);

		}

	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getButton() == MouseEvent.BUTTON1) {
			contador = 0;
			principal.getModelo().darVehiculo().setPosX(0);
			principal.getModelo().darVehiculo().setDetenido(false);
			principal.moverVehiculo();
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			principal.getModelo().darVehiculo().setDetenido(true);
			principal.getModelo().darVehiculo().setDistanciaRecorrida(distancia);
			contador++;
		}

		if (contador >= 3) {
			String id = JOptionPane.showInputDialog("Ingrese documento");
			String nom = JOptionPane.showInputDialog("Ingrese nombre");
			principal.getModelo().calcularPuntaje(id, nom, distancia);
		}

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
