package grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice implements Comparable<Vertice>{
	
	/**
	 * Nome representativdo do nó.
	 */
	private String nome;
	
	/**
	 * Lista de adjacencia.
	 */
	private List<Aresta> adj;
	
	/**
	 * Construtor do vertice.
	 * @param nome
	 */
	public Vertice(final String nome) {
		this.nome = nome;
		adj = new ArrayList<Aresta>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Aresta> getAdj() {
		return adj;
	}

	@Override
	public int compareTo(Vertice o) {
		if (this.nome == (o.nome)) {
			return 1;
		} else {			
			return 0;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(adj, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		return Objects.equals(adj, other.adj) && Objects.equals(nome, other.nome);
	}
	

}
