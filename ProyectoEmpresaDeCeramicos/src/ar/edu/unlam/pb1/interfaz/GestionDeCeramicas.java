package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.CajaDeCeramica;
import ar.edu.unlam.pb1.dominio.Sucursal;
import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;
import ar.edu.unlam.pb1.interfaz.enums.MenuPrincipal;

public class GestionDeCeramicas {

	private static final Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		MenuPrincipal opcionMenuPrincipal = null;
		Sucursal sucursal = new Sucursal("Sucursal");

		do {
			mostrarPorPantalla("\n\n\n" + sucursal.getNombre());

			opcionMenuPrincipal = obtenerOpcionDeEnumParaMenuPrincipal();

			switch (opcionMenuPrincipal) {
			case CALCULAR_CANTIDAD_CAJAS_CERAMICA_POR_AREA_COBERTURA:
				calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(sucursal);
				break;
			case AGREGAR_CAJAS_DE_CERAMICA_A_PEDIDO:
				agregarCajasDeCeramicaAPedido(sucursal);
				break;
			case OBTENER_MONTO_TOTAL_DE_PEDIDOS_UTILIZADOS:
				obtenerMontoTotalDeLosPedidosUtilizados(sucursal);
				break;
			case OBTENER_PROMEDIO_PRECIOS_CAJAS_CERAMICAS_POR_TIPO_CERAMICA_EN_PEDIDO:
				obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(sucursal);
				break;
			case SALIR:
				mostrarPorPantalla("\n\nHasta luego!");
				break;
			}

		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static void calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(Sucursal sucursal) {
		// TODO: Se debera ingresar el area (cantidad de metros cuadrados) a cubrir y la
		// caja de ceramicas deseada ((ver metodo obtenerCajaDeCeramica())). Luego
		// calcular la cantidad de cajas necesarias (ver en Sucursal) e informarla.

		double areaACubrir = ingresarDouble("\n Ingrese el area que necesita cubrir: ");
		CajaDeCeramica cajaDeseada = obtenerCajaDeCeramica(sucursal);

		mostrarPorPantalla("\nSe necesitan "
				+ sucursal.calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(areaACubrir, cajaDeseada)
				+ " cajas para cubrir el area");

	}

	private static void agregarCajasDeCeramicaAPedido(Sucursal sucursal) {
		// TODO: Se debera ingresar el numero de pedido, la caja de ceramicas que se
		// agregaran (ver metodo obtenerCajaDeCeramica()) y la cantidad de cajas a
		// agregar. Con estos tres datos, se deberan agregar las cajas al pedido de la
		// sucursal y mostrar un mensaje en caso de exito u otro en caso de no lograr
		// completar la operacion.

		int numeroDePedido = ingresarNumeroEntero("\nIngrese su numero de pedido: "),
				cantidadDeCajas = ingresarNumeroEntero("\nIngrese la cantidad necesaria de cajas: ");

		CajaDeCeramica cajaDeseada = obtenerCajaDeCeramica(sucursal);
		
		if (sucursal.agregarCajasDeCeramicaAPedido(numeroDePedido, cajaDeseada, cantidadDeCajas) == true) {
			// CASO DE EXITO
			mostrarPorPantalla("\nAgrego las cajas a su pedido exitosamente! ");
			
		} else {
			mostrarPorPantalla("\nERROR, las cajas no se han agregado. ");
		}
		

		

	}

	private static void obtenerMontoTotalDeLosPedidosUtilizados(Sucursal sucursal) {
		// TODO: obtener el monto total de los pedidos utilizados en la sucursal y
		// mostrarlo.

		mostrarPorPantalla("\nEste es el monto total de los pedidos utilizados en la sucursal "
				+ sucursal.obtenerMontoTotalDeLosPedidosUtilizados());

	}

	private static void obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(Sucursal sucursal) {
		// TODO: Se debera solicitar el ingreso del numero de pedido el cual no puede
		// ser menor que cero, ni mayor que la cantida de pedidos que puede tener la
		// sucursal. En caso de no ser valido, se debera continuar solicitando el
		// ingreso del dato, hasta que se ingrese un dato valido.
		// Se debera solicitar el ingreso del tipo de ceramica para el cual se calculara
		// el promedio (ver metodo ingresarTipoDeCeramica()) y luego se debera obtener y
		// mostrar
		// el promedio de precio de cajas de ceramica, en el pedido ingresado, para el
		// tipo de ceramica ingresado.
		int numeroPedido = 0;

		do {
			numeroPedido = ingresarNumeroEntero("\nIngrese el numero de pedido:");
		} while (numeroPedido <= 0 || numeroPedido > sucursal.CANTIDAD_PEDIDOS);

		mostrarPorPantalla("\nPromedio de cajas de ceramicas segun el tipo dentro del pedido: "
				+ sucursal.obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(numeroPedido,
						ingresarTipoDeCeramica()));

	}

	private static CajaDeCeramica obtenerCajaDeCeramica(Sucursal sucursal) {
		// TODO: Mostrar las cajas de ceramica disponibles ordenadas por tipo de
		// ceramica de manera ascendente, solicitar el ingreso del codigo de la caja de
		// ceramica y con este buscar la caja en la sucursal y devolverla.
		
		CajaDeCeramica [] cajasOrdenadas = sucursal.obtenerCeramicasDisponiblesOrdenadasPorTipoDeCeramicaAscendente();
		
		mostrarCeramicasDisponibles(cajasOrdenadas);

		String codigoDeCaja = ingresarString("\nIngrese el codigo de la caja deseada: ");

		return sucursal.buscarCajaDeCeramicaPorCodigo(codigoDeCaja);
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() {
		// TODO: mostrar las opciones del menu principal (ver metodo
		// mostrarMenuPrincipal()), solicitar el ingreso de la opcion deseada, obtenerla
		// desde el enum y devolverla.

		mostrarMenuPrincipal();

		mostrarPorPantalla("\nIngrese la opcion deseada: ");

		return MenuPrincipal.values()[TECLADO.nextInt() - 1];
	}

	private static TipoDeCeramica ingresarTipoDeCeramica() {
		// TODO: mostrar las opciones de los tipos de ceramica (ver metodo
		// mostrarTiposDeCeramica()), solicitar el ingreso de la opcion deseada,
		// obtenerla desde el enum y devolverla.

		mostrarTiposDeCeramica();

		mostrarPorPantalla("\nIngrese el tipo de ceramica que desea: ");

		return TipoDeCeramica.values()[TECLADO.nextInt() - 1];
	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.next();
	}

	private static double ingresarDouble(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.nextDouble();
	}

	private static void mostrarMenuPrincipal() {
		String menu = "";
		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			menu += "\n" + (i + 1) + ") " + MenuPrincipal.values()[i];
		}

		mostrarPorPantalla(menu);
	}

	private static void mostrarCeramicasDisponibles(CajaDeCeramica[] ceramicasDisponibles) {

		for (int i = 0; i < ceramicasDisponibles.length; i++) {
			mostrarPorPantalla(ceramicasDisponibles[i].toString());
		}

	}

	private static void mostrarTiposDeCeramica() {
		for (int i = 0; i < TipoDeCeramica.values().length; i++) {
			mostrarPorPantalla("\n" + (i + 1) + ") " + TipoDeCeramica.values()[i]);
		}
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
}
