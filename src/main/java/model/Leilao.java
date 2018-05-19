package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Leilao {

	private String titulo;
	private String descricao;
	private List<Lance> lances;
	private Calendar inicio;
	private Calendar fim;
	private Double valorInicial;
	
	public Leilao(String titulo, String descricao, Calendar inicio, Calendar fim, Double valorInicial) {
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicio = inicio;
		this.fim = fim;
		this.valorInicial = valorInicial;
		this.lances = new ArrayList<Lance>();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Calendar getInicio() {
		return inicio;
	}
	
	public Calendar getFim() {
		return fim;
	}
	
	public List<Lance> getLances() {
		return this.lances;
	}
	
	public Double valorInicial() {
		return this.valorInicial;
	}
}
