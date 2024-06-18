package ar.edu.unlam.pb2.dominio.instrumentos;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CasaDeMusica implements ICasaDeMusica {

	private String nombre;
	private List<Instrumento> instrumentos;
	private List<Evento> eventos;
	
	public CasaDeMusica(String nombre) {
		this.nombre = nombre;
		this.instrumentos = new ArrayList<>();
		this.eventos = new ArrayList<>();
	}

	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public Boolean agregarInstrumento(Instrumento instrumento) {
		return instrumentos.add(instrumento);
	}

	@Override
	public Instrumento buscarInstrumentoPorCodigo(Integer codigo) {
		Instrumento instrumento = null;

		for (Instrumento i : this.instrumentos) {

			if (i.getCodigo().equals(codigo)) {
				instrumento = i;
				break;
			}
		}

		return instrumento;
	}

	@Override
	public Double obtenerPrecioInstrumento(Integer codigo) {
		Instrumento instrumento = this.buscarInstrumentoPorCodigo(codigo);
		return instrumento.obtenerPrecio();
	}

	@Override
	public Boolean agregarEvento(Evento evento) {
		return this.eventos.add(evento);
	}

	@Override
	public Boolean agregarConciertoAEvento(Evento evento, Concierto concierto) {
		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				e.agregarConcierto(concierto);
				return true;
			}
		}
		return null;
	}

	@Override
	public Boolean asignarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto, Instrumento instrumento) {

		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				for (ConciertoInstrumento ci : e.getConciertosInstrumentos()) {

					if (ci.getConcierto().equals(concierto)) {
						ci.setInstrumento(instrumento);
						return true;
					}
				}

			}
		}
		return null;
	}

	@Override
	public Boolean agregarConciertoInstrumentoAEvento(Evento evento, Concierto concierto, Instrumento instrumento) {

		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				e.agregarConciertoInstrumento(new ConciertoInstrumento(concierto, instrumento));
				return true;

			}
		}

		return null;
	}
	
	@Override
	public List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento, Concierto concierto) {
		List<Instrumento> instrumentosDelConcierto = new ArrayList<>();
		
		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				for (ConciertoInstrumento ci : e.getConciertosInstrumentos()) {

					if (ci.getConcierto().equals(concierto)) {
						
						instrumentosDelConcierto.add(ci.getInstrumento());
						
					}
				}

			}
		}

		return instrumentosDelConcierto;
	}

	public List<Instrumento> obtenerInstrumentosGuitarraElectrica() {
		List<Instrumento> instrumentosGuitarraElectrica = new ArrayList<>();

		for (Instrumento instrumento : this.instrumentos) {

			if (instrumento instanceof GuitarraElectrica) {
				instrumentosGuitarraElectrica.add(instrumento);
			}
		}

		return instrumentosGuitarraElectrica;
	}

	public List<Instrumento> obtenerInstrumentosOrdenados() {
		/* forma 1 con expresiones lamdas
		//Collections.sort(instrumentos, (o1, o2) -> o1.getCodigo().compareTo(o2.getCodigo()));
		*/
		Collections.sort(instrumentos);
		return this.instrumentos;
	}
	
	public HashSet <Instrumento> obtenerInstrumentosSinRepetir(){	
		 HashSet <Instrumento> instrumentosNoRepetidos = new  HashSet <Instrumento>();
		 
		 instrumentosNoRepetidos.addAll(this.instrumentos);
		 return instrumentosNoRepetidos;
							 	
	}
	
	public TreeSet <Instrumento> obtenerInstrumentosOrdenadosPorNatural(){	
		TreeSet <Instrumento> instrumentosNoRepetidos = new  TreeSet <Instrumento>();
		 
		for (Instrumento instrumento : instrumentos) {
			instrumentosNoRepetidos.add(instrumento);
		}	
		 //instrumentosNoRepetidos.addAll(this.instrumentos);
		 return instrumentosNoRepetidos;
						 	
	}

	public TreeSet <Instrumento> obtenerInstrumentosOrdenadosOrdenEspecifico(){
		TreeSet <Instrumento> instrumentosNoRepetidos = new  TreeSet <Instrumento>(new OrdenDescenciente());
		 		
		instrumentosNoRepetidos.addAll(this.instrumentos);
		return instrumentosNoRepetidos;			
			 	
	}


	//se agrego esto
	public List<Concierto> obtenerConciertosDondeSeUtilizoInstrumento(Instrumento instrumento) {
	    List<Concierto> conciertosConInstrumento = new ArrayList<>();
	    
	    for (Evento evento : eventos) {
	        for (ConciertoInstrumento ConciertosInstrumentos : evento.getConciertosInstrumentos()) {
	            if (ConciertosInstrumentos.getInstrumento().equals(instrumento)) {
	                conciertosConInstrumento.add(ConciertosInstrumentos.getConcierto());
	            }
	        }
	    }
	    return conciertosConInstrumento;
	}

	//se agrego esto
	public List<Evento> obtenerEventosDondeSeDioConcierto(Concierto concierto) {
	    List<Evento> eventosConConcierto = new ArrayList<>();

	    for (Evento evento : eventos) {
	        for (ConciertoInstrumento ConciertosInstrumentos : evento.getConciertosInstrumentos()) {
	            if (ConciertosInstrumentos.getConcierto().equals(concierto)) {
	            	eventosConConcierto.add(evento);
	            }
	        }
	    }
	    return eventosConConcierto;
	}


}


