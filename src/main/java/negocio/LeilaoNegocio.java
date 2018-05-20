package negocio;

import java.util.Calendar;
import java.util.List;

import exception.LeilaoException;
import model.LanceModel;
import model.PessoaModel;

public interface LeilaoNegocio {

	public boolean validaLeilao(String titulo, String descricao, Calendar inicio, Calendar fim, Double valorInicial) 
			throws LeilaoException;
	
	public boolean criarLance(LanceModel lance);
	
	public boolean validaValorLance(LanceModel lance);
	
	public boolean validaUsuarioLance(LanceModel lance);
	
	public boolean validaDataLance(LanceModel lance);
	
	public PessoaModel getVencedor();
	
	public Double getValorMaiorLance();
	
	public Double getValorMenorLance();
	
	public List<LanceModel> getLances();
	
}
