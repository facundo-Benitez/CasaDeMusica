package ar.edu.unlam.pb2.dominio.instrumentos;

public abstract class Instrumento implements Comparable<Instrumento>{

	private Integer codigo;
	private String color;
	private String marca;
	private String modelo;
	private Integer anioFabricacion;
	private Integer stock;
	private Double precioBase;

	public Instrumento(Integer codigo, String color, String marca, Integer stock, String modelo, Integer anioFabricacion, Double precioBase) {
		this.codigo = codigo;
		this.color = color;
		this.marca = marca;
		this.stock = stock;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.precioBase = precioBase;
	}
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getColor() {
		return color;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public Integer getCodigo() {
		return this.codigo;
	}
	
	public Double getPrecioBase() {
		return this.precioBase;
	}
	
	public abstract String emitirSonido();
	public abstract Double obtenerPrecio();

	@Override
	public int compareTo(Instrumento o) {
			return this.codigo.compareTo(o.getCodigo());
	}

}
