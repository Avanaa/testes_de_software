package neg;

import java.util.Calendar;
import java.util.List;

import model.Lance;
import model.Leilao;
import model.Pessoa;

public class LeilaoNegocio {
	
	private Leilao leilao;
	
	public LeilaoNegocio(String titulo, String descricao, Calendar inicio, Calendar fim, Double valorInicial) {
		this.leilao = new Leilao(titulo, descricao, inicio, fim, valorInicial);
	}

	public boolean criarLance(LanceNegocio lance) {
		
		if(lance.getModel().getData().before(this.leilao.getFim()) 
				&& lance.getModel().getData().after(this.leilao.getFim())) {
			
			if(lance.getModel().getValor() > this.leilao.valorInicial() 
					&& lance.getModel().getValor() > this.getMaiorLance().getValor()) {
				
				return this.leilao.getLances().add(lance.getModel());
				
			} else {
				return false;
			}
		}
		 else {
			return false;
		}
	}
	
	public Pessoa getVencedor() {
		return this.getMaiorLance().getPessoa();
	}
	
	public Lance getMaiorLance() {
		
		Lance maiorLance = new Lance(null, Double.NEGATIVE_INFINITY);
		
		for(Lance lance : this.leilao.getLances()) {
			if(lance.getValor() > maiorLance.getValor()) {
				maiorLance = lance;
			}
		}
		return maiorLance;
	}
	
	public Lance getMenorLance() {
		
		Lance menorLance = new Lance(null, Double.POSITIVE_INFINITY);
		
		for(Lance lance : this.leilao.getLances()) {
			if(lance.getValor() < menorLance.getValor()) { 
				menorLance = lance;
				}
		}
		return menorLance;
	}
	
	public List<Lance> getLances(){
		return this.leilao.getLances();
	}
}
