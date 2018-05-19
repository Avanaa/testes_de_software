package model;

import java.util.Calendar;

public class Lance {
	
	private Pessoa pessoa;
	private Double valor;
	private Calendar data;
	
	public Lance(Pessoa pessoa, Double valor) {
		this.pessoa = pessoa;
		this.valor = valor;
		this.data = Calendar.getInstance();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public Calendar getData() {
		return data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lance other = (Lance) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
