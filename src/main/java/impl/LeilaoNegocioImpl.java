package impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exception.LeilaoException;
import model.LanceModel;
import model.LeilaoModel;
import model.PessoaModel;
import negocio.LeilaoNegocio;

public class LeilaoNegocioImpl extends LeilaoModel implements LeilaoNegocio {

	public LeilaoNegocioImpl(String titulo, String descricao, Calendar inicio, Calendar fim, Double valorInicial)
			throws LeilaoException {

		if (validaLeilao(titulo, descricao, inicio, fim, valorInicial)) {

			this.setTitulo(titulo);
			this.setDescricao(descricao);
			this.setInicio(inicio);
			this.setFim(fim);
			this.setValorInicial(valorInicial);
			this.setLances(new ArrayList<LanceModel>());
		}
	}

	public boolean validaLeilao(String titulo, String descricao, Calendar inicio, Calendar fim, Double valorInicial)
			throws LeilaoException {

		if (titulo == null || titulo.equals("")) {
			throw new LeilaoException(LeilaoException.TITULO_INVALIDO);
		}

		if (descricao == null || descricao.equals("")) {
			throw new LeilaoException(LeilaoException.DESCRICAO_INVALIDA);
		}

		if ((inicio == null) || (inicio.before(Calendar.getInstance()))) {
			throw new LeilaoException(LeilaoException.DATA_INICIO_INVALIDA);
		}

		if ((fim == null) || fim.before(Calendar.getInstance()) || fim.before(inicio)) {
			throw new LeilaoException(LeilaoException.DATA_FIM_INVALIDA);
		}

		if (valorInicial == null || valorInicial.isNaN() || valorInicial.isInfinite() || valorInicial == 0.0) {
			throw new LeilaoException(LeilaoException.VALOR_INICIAL_INVALIDO);
		}

		return true;
	}
	
	public boolean criarLance(LanceModel lance) {
		
		synchronized(this.getLances()) {
			
			if (this.validaValorLance(lance) && this.validaUsuarioLance(lance) && this.validaDataLance(lance)) {
				return this.getLances().add(lance);
			} else {
				return false;
			}	
		}
	}

	public boolean validaValorLance(LanceModel lance) {
		return lance.getValor() > this.valorInicial() && (lance.getValor() > this.getValorMaiorLance());
	}

	public boolean validaUsuarioLance(LanceModel lance) {
		if (this.getLances().isEmpty()) {
			return true;
		} else {
			return !this.getLances().get((this.getLances().size() - 1)).getPessoa().equals(lance.getPessoa());
		}
	}

	public boolean validaDataLance(LanceModel lance) {
		return lance.getData().before(this.getFim()) && lance.getData().after(this.getInicio());
	}

	public PessoaModel getVencedor() {

		if (super.getVencedor() == null) {

			if (this.getFim().after(Calendar.getInstance()) && this.getLances().size() > 0) {

				Collections.sort(this.getLances(), new Comparator<LanceModel>() {

					public int compare(LanceModel lance, LanceModel o) {
						return lance.getValor().compareTo(o.getValor());
					}
				});
				super.setVencedor(this.getLances().get((this.getLances().size() - 1)).getPessoa());
			}
		}
		return super.getVencedor();
	}

	public Double getValorMaiorLance() {

		LanceModel maiorLance;

		if (this.getLances().size() > 0) {

			maiorLance = this.getLances().get(0);

			for (LanceModel lance : this.getLances()) {
				if (lance.getValor() > maiorLance.getValor()) {
					maiorLance = lance;
				}
			}
			return maiorLance.getValor();

		} else {
			return 0.0;
		}
	}

	public Double getValorMenorLance() {

		LanceModel menorLance;

		menorLance = this.getLances().get(0);

		for (LanceModel lance : this.getLances()) {
			if (lance.getValor() < menorLance.getValor()) {
				menorLance = lance;
			}
		}
		return menorLance.getValor();
	}

	public List<LanceModel> getLances() {
		return super.getLances();
	}
}
