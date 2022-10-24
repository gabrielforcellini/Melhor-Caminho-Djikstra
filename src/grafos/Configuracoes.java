package grafos;

import java.util.Objects;

public class Configuracoes {
	private String diretorioRaiz;
	private String diretorioSucesso;
	private String diretorioErro;
	private Boolean rotaAutomatica;
	
	public Configuracoes(String diretorioRaiz, String diretorioSucesso, String diretorioErro, Boolean rotaAutomatica) {
		super();
		this.diretorioRaiz = diretorioRaiz;
		this.diretorioSucesso = diretorioSucesso;
		this.diretorioErro = diretorioErro;
		this.rotaAutomatica = rotaAutomatica;
	}
	
	public Configuracoes() {
		
	}
	
	public String getDiretorioRaiz() {
		return diretorioRaiz;
	}
	public void setDiretorioRaiz(String diretorioRaiz) {
		this.diretorioRaiz = diretorioRaiz;
	}
	public String getDiretorioSucesso() {
		return diretorioSucesso;
	}
	public void setDiretorioSucesso(String diretorioSucesso) {
		this.diretorioSucesso = diretorioSucesso;
	}
	public String getDiretorioErro() {
		return diretorioErro;
	}
	public void setDiretorioErro(String diretorioErro) {
		this.diretorioErro = diretorioErro;
	}
	public Boolean getRotaAutomatica() {
		return rotaAutomatica;
	}
	public void setRotaAutomatica(Boolean rotaAutomatica) {
		this.rotaAutomatica = rotaAutomatica;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diretorioErro, diretorioRaiz, diretorioSucesso, rotaAutomatica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuracoes other = (Configuracoes) obj;
		return Objects.equals(diretorioErro, other.diretorioErro) && Objects.equals(diretorioRaiz, other.diretorioRaiz)
				&& Objects.equals(diretorioSucesso, other.diretorioSucesso)
				&& Objects.equals(rotaAutomatica, other.rotaAutomatica);
	}

	@Override
	public String toString() {
		return "Diretorio Raiz=" + diretorioRaiz + "\nDiretorio Sucesso=" + diretorioSucesso
				+ "\nDiretorio Erro=" + diretorioErro + ", \nRota Automatica=" + rotaAutomatica;
	}
}
