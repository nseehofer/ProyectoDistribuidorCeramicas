package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

public class Pedido {

	private static int proximoNumero = 1;
	private int numero;
	private boolean utilizado;
	private final int CANTIDAD_MAXIMA_CERAMICAS = 10000;
	private CajaDeCeramica[] ceramicas;

	public Pedido() {
		this.numero = proximoNumero++;
		this.ceramicas = new CajaDeCeramica[CANTIDAD_MAXIMA_CERAMICAS];

	}

	public boolean agregarCajaDeCeramica(CajaDeCeramica ceramicaDeCeramica) {

		boolean seAgregoLaCaja = false;
		int indice = 0;

		while (indice < this.ceramicas.length && !seAgregoLaCaja) {
			if (this.ceramicas[indice] == null) {

				this.ceramicas[indice] = ceramicaDeCeramica;
				seAgregoLaCaja = true;
			}
			indice++;
		}
		return seAgregoLaCaja;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isUtilizado() {
		return utilizado;
	}

	public void setUtilizado(boolean utilizado) {
		this.utilizado = utilizado;
	}

	public CajaDeCeramica[] getCeramicas() {
		return ceramicas;
	}

	public void setCeramicas(CajaDeCeramica[] ceramicas) {
		this.ceramicas = ceramicas;
	}

	
	public String toString() {
		return "Pedido [numero=" + numero + ", utilizado=" + utilizado + ", ceramicas=" + Arrays.toString(ceramicas)
				+ "]";
	}

}
