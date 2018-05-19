package negocio;

import java.util.Calendar;
import java.util.List;

import exception.LeilaoException;
import model.LanceModel;
import model.LeilaoModel;
import model.PessoaModel;

public class LeilaoNegocio extends LeilaoModel {

	public LeilaoNegocio(String titulo, String descricao, Calendar inicio, Calendar fim, Double valorInicial) throws LeilaoException {

		if (validaLeilao(titulo, descricao, inicio, fim, valorInicial)) {

			this.setTitulo(titulo);
			this.setDescricao(descricao);
			this.setInicio(inicio);
			this.setFim(fim);
			this.setValorInicial(valorInicial);
		}
	}

	private boolean validaLeilao(String titulo, String descricao, Calendar inicio, Calendar fim, Double valorInicial)
			throws LeilaoException {

		if (titulo == null || titulo.equals("")) {
			throw new LeilaoException(LeilaoException.TITULO_INVALIDO);
		}

		if (descricao == null || descricao.equals("")) {
			throw new LeilaoException(LeilaoException.DESCRICAO_INVALIDA);
		}

		if (inicio.before(Calendar.getInstance())) {
			throw new LeilaoException(LeilaoException.DATA_INICIO_INVALIDA);
		}

		if (fim.before(Calendar.getInstance()) || fim.before(inicio)) {
			throw new LeilaoException(LeilaoException.DATA_FIM_INVALIDA);
		}

		if (valorInicial.isNaN() || valorInicial.isInfinite() || valorInicial.equals(0)) {
			throw new LeilaoException(LeilaoException.VALOR_INICIAL_INVALIDO);
		}

		return true;
	}

	public boolean criarLance(LanceModel lance) {

		if (this.validaValorLance(lance) && this.validaUsuarioLance(lance) && this.validaDataLance(lance)) {
			return this.getLances().add(lance);
		} else {
			return false;
		}
	}

	private boolean validaValorLance(LanceModel lance) {
		return lance.getValor() > this.valorInicial() && lance.getValor() > this.getMaiorLance().getValor();
	}

	private boolean validaUsuarioLance(LanceModel lance) {
		if(this.getLances().isEmpty()) {
			return true;
		} else {
			return !this.getLances().get((this.getLances().size() - 1)).getPessoa().equals(lance.getPessoa());	
		}
	}
	
	private boolean validaDataLance(LanceModel lance) {
		return lance.getData().before(this.getFim()) && lance.getData().after(this.getInicio());
	}

	public PessoaModel getVencedor() {

		if (this.getVencedor().equals(null)) {
			if (this.getFim().after(Calendar.getInstance())) {
				this.setVencedor(this.getMaiorLance().getPessoa());
				return this.getMaiorLance().getPessoa();
			} else {
				return null;
			}
		} else {
			return this.getVencedor();
		}
	}

	public LanceModel getMaiorLance() {

		LanceModel maiorLance = this.getLances().get(0);

		for (LanceModel lance : this.getLances()) {
			if (lance.getValor() > maiorLance.getValor()) {
				maiorLance = lance;
			}
		}
		return maiorLance;
	}

	public LanceModel getMenorLance() {

		LanceModel menorLance = this.getLances().get(0);

		for (LanceModel lance : this.getLances()) {
			if (lance.getValor() < menorLance.getValor()) {
				menorLance = lance;
			}
		}
		return menorLance;
	}

	public List<LanceModel> getLances() {
		return this.getLances();
	}
}
