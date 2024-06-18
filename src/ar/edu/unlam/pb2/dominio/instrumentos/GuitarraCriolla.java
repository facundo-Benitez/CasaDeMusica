package ar.edu.unlam.pb2.dominio.instrumentos;

public class GuitarraCriolla extends Instrumento {
	private final Double PORCENTAJE_GANANCIA = 1.0;

	private Integer cantidadDeCuerdas;
	
	public GuitarraCriolla(Integer codigo, Integer cantidadDeCuerdas, String color, String marca, Integer stock, String modelo,
			Integer anioFabricacion, Double precioBase) {
		super(codigo, color, marca, stock, modelo, anioFabricacion, precioBase);
		this.cantidadDeCuerdas = cantidadDeCuerdas;
	}

	public Integer getCantidadDeCuerdas() {
		return cantidadDeCuerdas;
	}
	
	@Override
	public String emitirSonido() {
		return "Sonido de guitarra";
	}

	@Override
	public Double obtenerPrecio() {
		return this.getPrecioBase() * PORCENTAJE_GANANCIA;
	}

}
