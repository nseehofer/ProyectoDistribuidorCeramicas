package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class Sucursal {
	// TODO: Completar el constructor, getter, setters y método necesarios para
	// asegurar el correcto funcionamiento

	public static final int CANTIDAD_PEDIDOS = 10000;

	private String nombre;
	private CajaDeCeramica[] ceramicasDisponibles;
	private Pedido[] pedidos;
	
	public Sucursal(String nombre) {
		this.nombre = nombre;
		this.agregarCeramicasDisponibles(); // Esta linea debe ejecutarse en el constructor
		this.cargarPedidos(); // Esta linea debe ejecutarse en el constructor
	}

	public CajaDeCeramica buscarCajaDeCeramicaPorCodigo(String codigoCajaDeCeramica) {
		// TODO: Buscar y devolver la caja de ceramica que cumpla con el codigo
		// suministrado. Es necesario no discernir entre mayusculas y minusculas (el
		// usuario puede ingresar el codigo tanto con mayusculas como con minusculas).

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
		// TODO Calcular y devolver la cantidad de cajas necesarias para cubrir el area
		// especificada. Cada caja conoce el area de cobertura segun el tamanio de las
		// ceramicas. Necesitamos entonces dividir el area a cubrir, con el area de
		// cobertura de una caja, para conocer cuantas cajas se necesitan. En caso de
		// que la division contenga decimales, se debera redondear al siguiente numero
		// entero.

		double areaDeCoberturaDeLaCaja = cajaDeCeramica.obtenerAreaDeCoberturaDeUnaCaja();

		int cantidadDeCajasNecesarias = (int) (areaACubrir / areaDeCoberturaDeLaCaja) + 1;

		return cantidadDeCajasNecesarias;
	}

	public boolean agregarCajasDeCeramicaAPedido(int numeroPedido, CajaDeCeramica cajaDeCeramica, int cantidadCajas) {
		// TODO: Agregar al pedido la cantidad de cajas de ceramica especificada como
		// parametro.
		// Cuando se agregan cajas de ceramica a un pedido, el mismo se debe marcar como
		// utilizado.
		// Devuelve verdadero en caso de poder agregar todas las
		// cajas. Caso contrario, devuelve falso.

		boolean cajasAgregadas = false;
		int indice = 0;
		int contadorDeCajasAgregadas = 0;
		CajaDeCeramica[] cajasParaAgregarAlArray = new CajaDeCeramica[cantidadCajas];

		// NO ME AGREGA LA CANTIDAD DE CAJAS

		while (indice < this.pedidos.length && !cajasAgregadas) {
			if (this.pedidos[indice] != null && this.pedidos[indice].getNumero() == numeroPedido) {

				for (int posicion = 0; posicion < cajasParaAgregarAlArray.length; posicion++) {
					cajasParaAgregarAlArray[posicion] = cajaDeCeramica;
				}

				/*
				 * for (int posicion = 0 ; posicion < cantidadCajas; posicion++) {
				 * 
				 * this.pedidos[indice].getCeramicas()[posicion] ; }
				 */
				this.pedidos[numeroPedido - 1].setCeramicas(cajasParaAgregarAlArray);
				this.pedidos[numeroPedido - 1].setUtilizado(true);
				// this.pedidos[numeroPedido - 1].getCeramicas();
				cajasAgregadas = true;
			}

			indice++;
		}

		return cajasAgregadas;
	}

	public double obtenerMontoTotalDeLosPedidosUtilizados() {
		// TODO: Calcular y devolver el monto total de los pedidos utilizados.

		boolean pedidosNoUtilizados = false;
		int indice = 0;
		double montoTotal = 0;

		while (indice < this.pedidos.length && !pedidosNoUtilizados) {
			if (this.pedidos[indice] != null && this.pedidos[indice].isUtilizado() == true) {

				// LA VERDAD NO SE SI ESTA BIEN... SOLO HICE LO POSIBLE PARA OBTENER EL
				// "getPrecio" de manera tal
				// que no tenga que armar mil quinientos metodos para ello, sino ver alguna
				// forma fluida en el codigo.
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

		// TODO: Dado el numero de pedido y el tipo de ceramica,
		// obtener el promedio de precio de cajas de ceramica incluidas en dicho pedido
		// que sean del tipo de
		// ceramica especificado.
		// NO ENTIENDO Si un pedido no fue utilizado, devolver cero.

		double promedio = 0, precioTotalDelTipoDeCeramica = 0;
		boolean encontreElPedido = false;
		int indice = 0, cantidadTotalDelTipoDeCeramica = 0;

		// PRIMERO RECORRO LOS PEDIDOS HASTA ENCONTRAR EL QUE QUIERE

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
		// TODO: Ordenar el array de cajas existente por tipo de ceramica ascendente y
		// devolverlo.

		// YA SE QUE LA NECESITO PORQUE DEBO ORDENAR UN ARRAY
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

	// ______METODOS HECHOS__________

	private void cargarPedidos() {
		// Metodo necesario para usar el soft
		if (this.pedidos == null) {
			this.pedidos = new Pedido[CANTIDAD_PEDIDOS];
		}

		for (int i = 0; i < CANTIDAD_PEDIDOS; i++) {
			this.pedidos[i] = new Pedido();
		}
	}

	// ________________

	private void agregarCeramicasDisponibles() {
		// Metodo necesario para usar el soft
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
