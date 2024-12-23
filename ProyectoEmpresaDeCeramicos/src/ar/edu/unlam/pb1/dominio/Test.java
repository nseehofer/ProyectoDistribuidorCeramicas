package ar.edu.unlam.pb1.dominio;

import java.util.Scanner;

public class Test {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double prueba1 = 2;
		double prueba2 = 3.6;
		int prueba3 = (int) (prueba1 * prueba2);

		System.out.println("\nPrueba con 2 x 3.6: " + prueba3);

		prueba2 = 3.1;
		prueba3 = (int) (prueba1 * prueba2);
		System.out.println("\nPrueba con 2 x 3.1: " + prueba3);

		// SE CONFIRMA QUE EL CASTEO ES SIEMPRE PARA EL SIGUIENTE

		/*
		 * PruebaEnum opcion = null;
		 * 
		 * System.out.println("\nPRUEBAS CON compareTo: ");
		 * 
		 * System.out.println( "\nPrueba enum ANTIDESLIZANTE VS NORMAL: " +
		 * PruebaEnum.ANTIDESLIZANTE.compareTo(PruebaEnum.NORMAL));
		 * 
		 * System.out.println("\n*******************************");
		 * 
		 * System.out.println( "\nPrueba enum NORMAL VS ANTIDESLIZANTE: " +
		 * PruebaEnum.NORMAL.compareTo(PruebaEnum.ANTIDESLIZANTE));
		 * System.out.println("\nPrueba enum NORMAL VS JOYA: " +
		 * PruebaEnum.NORMAL.compareTo(PruebaEnum.JOYA));
		 * System.out.println("\nPrueba enum NORMAL VS NORMAL: " +
		 * PruebaEnum.NORMAL.compareTo(PruebaEnum.NORMAL));
		 * 
		 * System.out.println("\n*******************************");
		 * 
		 * System.out.println("\nPRUEBAS CON ORDINAL: ");
		 * 
		 * System.out.println( "\nPrueba enum NORMAL VS REPIOLA: " +
		 * (PruebaEnum.NORMAL.ordinal() < PruebaEnum.REPIOLA.ordinal()));
		 * System.out.println("\nPrueba enum NORMAL VS ANTIDESLIZANTE: " +
		 * (PruebaEnum.NORMAL.ordinal() < PruebaEnum.ANTIDESLIZANTE.ordinal()));
		 * System.out .println("\nPrueba enum NORMAL VS JOYA: " +
		 * (PruebaEnum.NORMAL.ordinal() < PruebaEnum.JOYA.ordinal()));
		 * System.out.println( "\nPrueba enum NORMAL VS NORMAL: " +
		 * (PruebaEnum.NORMAL.ordinal() < PruebaEnum.NORMAL.ordinal()));
		 * 
		 * System.out.println("\n*******************************");
		 * 
		 * int valorPrueba = 0 , valorMaximo = 10000;
		 * 
		 * do { System.out.println("\nIngrese valor: "); valorPrueba =
		 * teclado.nextInt();
		 * 
		 * } while (valorPrueba <= 0 || valorPrueba > valorMaximo);
		 * 
		 * 
		 * System.out.println("\nLo entendiste amigo!");
		 * 
		 * /* System.out.println("\nPrueba enum NORMAL VS ANTIDESLIZANTE: " +
		 * PruebaEnum.values());
		 * System.out.println("\nPrueba enum NORMAL VS ANTIDESLIZANTE: " +
		 * PruebaEnum.ANTIDESLIZANTE);
		 */
	}

}
