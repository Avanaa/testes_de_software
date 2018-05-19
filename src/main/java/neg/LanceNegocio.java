package neg;

import model.Lance;
import model.Pessoa;

public class LanceNegocio {
	
	private Lance model;
	
	public LanceNegocio(Pessoa pessoa, Double valor){
		this.model = new Lance(pessoa, valor);
	}
	
	public Lance getModel() {
		return this.model;
	}
}
