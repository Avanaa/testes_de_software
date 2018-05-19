package model;

import java.util.Calendar;
import java.util.List;

public abstract class LeilaoModel {

	private String titulo;
	private String descricao;
	private List<LanceModel> lances;
	private Calendar inicio;
	private Calendar fim;
	private Double valorInicial;
	private PessoaModel vencedor;

	public String getTitulo() {
		return titulo;
	}
	
	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getInicio() {
		return inicio;
	}
	
	protected void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getFim() {
		return fim;
	}
	
	protected void setFim(Calendar fim) {
		this.fim = fim;
	}

	public List<LanceModel> getLances() {
		return this.lances;
	}
	
	public Double valorInicial() {
		return this.valorInicial;
	}
	
	protected void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public PessoaModel getVencedor() {
		return vencedor;
	}

	protected void setVencedor(PessoaModel vencedor) {
		this.vencedor = vencedor;
	}
	
	
}
