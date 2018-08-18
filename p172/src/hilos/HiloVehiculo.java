package hilos;

import modelo.Vehiculo;
import vista.VentanaPruebaTransito;

public class HiloVehiculo extends Thread {
	private Vehiculo modelo;
	private VentanaPruebaTransito principal;

	public HiloVehiculo(Vehiculo veh, VentanaPruebaTransito ven) {
		// TODO Auto-generated constructor stub
		modelo = veh;
		principal = ven;
	}

	public void run() {

		while (modelo.estaDetenido() == false) {

			modelo.avanzar(10);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			principal.repaint();

		}

	}

}
