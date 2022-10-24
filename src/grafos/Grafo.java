package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Vertice> listaVertices;
	private int ContDup = 0;
	private int ContNeg = 0;
	private int ContNos = 0;
	
	public Grafo() {
		listaVertices = new ArrayList<Vertice>();
	}
	
	public Vertice addVertice(final String nome) {
		Vertice v = new Vertice(nome);
		if(nome.length() == 4) {
			ContNeg++;
		} else if (verificaDupilicade(v)) {
			ContDup++;
		} else {
			listaVertices.add(v);
			ContNos++;
		}
		return v;
	}
	
	public List<Vertice> getListaVertices() {
		return listaVertices;
	}

	public int getContDup() {
		return ContDup;
	}

	public int getContNeg() {
		return ContNeg;
	}

	public Aresta addAresta(final Vertice origem, final Vertice destino) {
		Aresta a = new Aresta(origem, destino);
		origem.getAdj().add(a);
		return a;
	}
	
	private boolean verificaDupilicade(Vertice v) {
		for (Vertice ve : listaVertices) {
			if(ve.equals(v)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		String r = "";
		for (Vertice v : listaVertices) {
			r += v.getNome() + " -> ";
			for (Aresta a : v.getAdj()) {
				v = a.getDestino();
				r += "["+v.getNome()+"] ->";
			}
			r += "[/]";
			r += "\n";
		}		
		return r;
	}

	public int getContNos() {
		return ContNos;
	}

}









