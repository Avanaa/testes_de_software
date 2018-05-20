package negocio;

import java.util.Calendar;

import exception.LanceException;
import model.LanceModel;
import model.PessoaModel;

public class LanceNegocio extends LanceModel{

	public LanceNegocio(PessoaModel pessoa, Double valor) throws LanceException {
		
		if(pessoa == null) {
			throw new LanceException(LanceException.USUARIO_INVALIDO);
		}
		
		if(valor.isNaN() || valor.isInfinite() || (valor == 0.0)) {
			throw new LanceException(LanceException.VALOR_INVALIDO);
		}
		
		this.setPessoa(pessoa);
		this.setValor(valor);
		Calendar data = Calendar.getInstance();
		this.setData(data);
	}
	
	public void setData(Calendar data) {
		super.setData(data);
	}
}
