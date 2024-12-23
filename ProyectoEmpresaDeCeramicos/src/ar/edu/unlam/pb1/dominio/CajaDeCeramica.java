package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class CajaDeCeramica {
	// TODO: Completar el constructor, getters, setters y metodos necesarios para
	// garantizar el correcto funcionamiento. El
	// precio de la caja se calcula en base al precio de la ceramica por la cantidad
	// que trae la caja.

	private double alturaDeCeramica;
	private double largoDeCeramica;
	private double precio;
	private int cantidadEnCaja;
	private String codigo;
	private String nombre;
	private TipoDeCeramica tipoDeCeramica;

	public CajaDeCeramica(String codigo, String nombre, double altura, double largo, double precioDeCeramica,
			TipoDeCeramica tipoDeCeramica, int cantidadEnCaja) {

		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precioDeCeramica;
		this.alturaDeCeramica = altura;
		this.largoDeCeramica = largo;
		this.cantidadEnCaja = cantidadEnCaja;
		this.tipoDeCeramica = tipoDeCeramica;

	}

	public double obtenerAreaDeCoberturaDeUnaCaja() {
		return this.largoDeCeramica * this.alturaDeCeramica * this.cantidadEnCaja;
	}

	// ___________________________
	
	
	public String toString() {
		return "CajaDeCeramica [alturaDeCeramica=" + alturaDeCeramica + ", largoDeCeramica=" + largoDeCeramica
				+ ", precio=" + precio + ", cantidadEnCaja=" + cantidadEnCaja + ", codigo=" + codigo + ", nombre="
				+ nombre + ", tipoDeCeramica=" + tipoDeCeramica + "]";
	}

	public double getAlturaDeCeramica() {
		return alturaDeCeramica;
	}

	public void setAlturaDeCeramica(double alturaDeCeramica) {
		this.alturaDeCeramica = alturaDeCeramica;
	}

	public double getLargoDeCeramica() {
		return largoDeCeramica;
	}

	public void setLargoDeCeramica(double largoDeCeramica) {
		this.largoDeCeramica = largoDeCeramica;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadEnCaja() {
		return cantidadEnCaja;
	}

	public void setCantidadEnCaja(int cantidadEnCaja) {
		this.cantidadEnCaja = cantidadEnCaja;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeCeramica getTipoDeCeramica() {
		return tipoDeCeramica;
	}

	public void setTipoDeCeramica(TipoDeCeramica tipoDeCeramica) {
		this.tipoDeCeramica = tipoDeCeramica;
	}
	
	
	

}
