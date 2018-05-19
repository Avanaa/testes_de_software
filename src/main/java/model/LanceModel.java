package model;

import java.util.Calendar;

public abstract class LanceModel {

	private PessoaModel pessoa;
	private Double valor;
	private Calendar data;
	
	public PessoaModel getPessoa() {
		return pessoa;
	}
	
	protected void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}
	
	public Double getValor() {
		return valor;
	}
	
	protected void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Calendar getData() {
		return data;
	}
	
	protected void setData(Calendar data) {
		this.data = data;
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
		LanceModel other = (LanceModel) obj;
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
