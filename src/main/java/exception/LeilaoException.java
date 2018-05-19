package exception;

public class LeilaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String VALOR_INICIAL_INVALIDO = "Valor inicial inválido";
	public static final String DATA_FIM_INVALIDA = "Data fim inválida";
	public static final String DATA_INICIO_INVALIDA = "Data de início inválida";
	public static final String DESCRICAO_INVALIDA = "Descrição inválida";
	public static final String TITULO_INVALIDO = "Titulo inválido";

	public LeilaoException(String s) {
		super(s);
	}
}
