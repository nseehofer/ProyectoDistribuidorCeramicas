package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class Sucursal {

	public static final int CANTIDAD_PEDIDOS = 10000;

	private String nombre;
	private CajaDeCeramica[] ceramicasDisponibles;
	private Pedido[] pedidos;

	public Sucursal(String nombre) {
		this.nombre = nombre;
		this.agregarCeramicasDisponibles();
		this.cargarPedidos();
	}

	public CajaDeCeramica buscarCajaDeCeramicaPorCodigo(String codigoCajaDeCeramica) {

		CajaDeCeramica cajaEncontrada = null;
		boolean encontrada = false;
		int indice = 0;

		while (indice < this.ceramicasDisponibles.length && !encontrada) {

			if (this.ceramicasDisponibles[indice].getCodigo().equalsIgnoreCase(codigoCajaDeCeramica)) {

				cajaEncontrada = this.ceramicasDisponibles[indice];
				encontrada = true;
			}

			indice++;

		}

		return cajaEncontrada;
	}

	public int calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(double areaACubrir, CajaDeCeramica cajaDeCeramica) {

		double areaDeCoberturaDeLaCaja = cajaDeCeramica.obtenerAreaDeCoberturaDeUnaCaja();

		int cantidadDeCajasNecesarias = (int) (areaACubrir / areaDeCoberturaDeLaCaja) + 1;

		return cantidadDeCajasNecesarias;
	}

	public boolean agregarCajasDeCeramicaAPedido(int numeroPedido, CajaDeCeramica cajaDeCeramica, int cantidadCajas) {

		boolean cajasAgregadas = false;
		int indice = 0;
		int contadorDeCajasAgregadas = 0;
		CajaDeCeramica[] cajasParaAgregarAlArray = new CajaDeCeramica[cantidadCajas];

		while (indice < this.pedidos.length && !cajasAgregadas) {
			if (this.pedidos[indice] != null && this.pedidos[indice].getNumero() == numeroPedido) {

				for (int posicion = 0; posicion < cajasParaAgregarAlArray.length; posicion++) {
					cajasParaAgregarAlArray[posicion] = cajaDeCeramica;
				}

				this.pedidos[numeroPedido - 1].setCeramicas(cajasParaAgregarAlArray);
				this.pedidos[numeroPedido - 1].setUtilizado(true);
				cajasAgregadas = true;
			}

			indice++;
		}

		return cajasAgregadas;
	}

	public double obtenerMontoTotalDeLosPedidosUtilizados() {

		boolean pedidosNoUtilizados = false;
		int indice = 0;
		double montoTotal = 0;

		while (indice < this.pedidos.length && !pedidosNoUtilizados) {
			if (this.pedidos[indice] != null && this.pedidos[indice].isUtilizado() == true) {

				for (int indiceBis = 0; indiceBis < this.pedidos[indice].getCeramicas().length; indiceBis++) {
					montoTotal += this.pedidos[indice].getCeramicas()[indiceBis].getPrecio();
				}

			}

			indice++;
		}

		return montoTotal;
	}

	public double obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(int numeroPedido,
			TipoDeCeramica tipoDeCeramica) {

		double promedio = 0, precioTotalDelTipoDeCeramica = 0;
		boolean encontreElPedido = false;
		int indice = 0, cantidadTotalDelTipoDeCeramica = 0;

		while (indice < this.pedidos.length && !encontreElPedido) {

			if (this.pedidos[indice] != null && this.pedidos[indice].getNumero() == numeroPedido)
				for (int indiceBis = 0; indiceBis < this.pedidos[indice].getCeramicas().length; indiceBis++) {

					if (this.pedidos[indice].getCeramicas()[indiceBis].getTipoDeCeramica().equals(tipoDeCeramica)) {
						cantidadTotalDelTipoDeCeramica += this.pedidos[indice].getCeramicas()[indiceBis]
								.getCantidadEnCaja();
						precioTotalDelTipoDeCeramica += this.pedidos[indice].getCeramicas()[indiceBis].getPrecio();
					}

					promedio = cantidadTotalDelTipoDeCeramica / precioTotalDelTipoDeCeramica;

					encontreElPedido = true;
				}

			indice++;
		}

		return promedio;
	}

	public CajaDeCeramica[] obtenerCeramicasDisponiblesOrdenadasPorTipoDeCeramicaAscendente() {

		CajaDeCeramica aux = null;

		for (int indice = 0; indice < this.ceramicasDisponibles.length; indice++) {
			for (int j = 0; j < this.ceramicasDisponibles.length - 1; j++) {
				if (this.ceramicasDisponibles[j] != null && this.ceramicasDisponibles[j + 1] != null) {
					if ((this.ceramicasDisponibles[j].getTipoDeCeramica()
							.compareTo(this.ceramicasDisponibles[j + 1].getTipoDeCeramica())) > 0) {
						aux = this.ceramicasDisponibles[j + 1];
						this.ceramicasDisponibles[j + 1] = this.ceramicasDisponibles[j];
						this.ceramicasDisponibles[j] = aux;
					}
				}
			}
		}

		return this.ceramicasDisponibles;
	}

	private void cargarPedidos() {

		if (this.pedidos == null) {
			this.pedidos = new Pedido[CANTIDAD_PEDIDOS];
		}

		for (int i = 0; i < CANTIDAD_PEDIDOS; i++) {
			this.pedidos[i] = new Pedido();
		}
	}

	private void agregarCeramicasDisponibles() {

		if (this.ceramicasDisponibles == null) {
			this.ceramicasDisponibles = new CajaDeCeramica[5];
		}

		int posicion = 0;
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("N" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.1, 0.1, 125.70, TipoDeCeramica.NORMAL, 100);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("AD" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.2, 0.2, 145.70, TipoDeCeramica.ANTI_DESLIZANTE, 35);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("AT" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.3, 0.3, 185.70, TipoDeCeramica.ALTO_TRANSITO, 25);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("AD" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.4, 0.4, 235.70, TipoDeCeramica.ANTI_DESLIZANTE, 10);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("N" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 50, 50, 500.70, TipoDeCeramica.NORMAL, 10);
	}

	public String toString() {
		return "Sucursal [nombre=" + nombre + ", ceramicasDisponibles=" + Arrays.toString(ceramicasDisponibles)
				+ ", pedidos=" + Arrays.toString(pedidos) + "]";
	}

	public String getNombre() {
		return this.nombre;
	}

	public CajaDeCeramica[] getCeramicasDisponibles() {
		return ceramicasDisponibles;
	}

	public void setCeramicasDisponibles(CajaDeCeramica[] ceramicasDisponibles) {
		this.ceramicasDisponibles = ceramicasDisponibles;
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
