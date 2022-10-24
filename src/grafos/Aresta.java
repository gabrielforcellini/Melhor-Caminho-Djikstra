package grafos;

public class Aresta {
	
	/**
	 * Nó origem.
	 */
	private Vertice origem;

	/**
	 * Nós destino.
	 */
	private Vertice destino;
	
	public Aresta(final Vertice origem, final Vertice destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public Vertice getOrigem() {
		return origem;
	}
	
	public Vertice getDestino() {
		return destino;
	}
	
}
