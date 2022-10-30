package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Caminho implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String caminhoArquivo;
	private Integer codigoCidadeOrigem;
	private String cidadeOrigem;
	private String cidadeDestino;
	private Integer codigoCidadeDestino;
	private Double Km;

	public Caminho(String caminhoArquivo, Integer codigoCidadeOrigem, String cidadeOrigem, String cidadeDestino,
			Integer codigoCidadeDestino, Double km) {
		super();
		this.caminhoArquivo = caminhoArquivo;
		this.codigoCidadeOrigem = codigoCidadeOrigem;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.codigoCidadeDestino = codigoCidadeDestino;
		Km = km;
	}
	
	public Caminho() {
		
	}
	
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}
	
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	public Integer getCodigoCidadeOrigem() {
		return codigoCidadeOrigem;
	}
	
	public void setCodigoCidadeOrigem(Integer codigoCidadeOrigem) {
		this.codigoCidadeOrigem = codigoCidadeOrigem;
	}
	
	public Integer getCodigoCidadeDestino() {
		return codigoCidadeDestino;
	}
	
	public void setCodigoCidadeDestino(Integer codigoCidadeDestino) {
		this.codigoCidadeDestino = codigoCidadeDestino;
	}
	
	public Double getKm() {
		return Km;
	}
	
	public void setKm(Double km) {
		Km = km;
	}
	
	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Km, caminhoArquivo, cidadeDestino, cidadeOrigem, codigoCidadeDestino, codigoCidadeOrigem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caminho other = (Caminho) obj;
		return Objects.equals(Km, other.Km) && Objects.equals(caminhoArquivo, other.caminhoArquivo)
				&& Objects.equals(cidadeDestino, other.cidadeDestino)
				&& Objects.equals(cidadeOrigem, other.cidadeOrigem)
				&& Objects.equals(codigoCidadeDestino, other.codigoCidadeDestino)
				&& Objects.equals(codigoCidadeOrigem, other.codigoCidadeOrigem);
	}

	@Override
	public String toString() {
		return "Caminho [caminhoArquivo=" + caminhoArquivo + ", codigoCidadeOrigem=" + codigoCidadeOrigem
				+ ", cidadeOrigem=" + cidadeOrigem + ", cidadeDestino=" + cidadeDestino + ", codigoCidadeDestino="
				+ codigoCidadeDestino + ", Km=" + Km + "]";
	}
	
}
