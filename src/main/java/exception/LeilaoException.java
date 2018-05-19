package exception;

public class LeilaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String VALOR_INICIAL_INVALIDO = "Valor inicial inv�lido";
	public static final String DATA_FIM_INVALIDA = "Data fim inv�lida";
	public static final String DATA_INICIO_INVALIDA = "Data de in�cio inv�lida";
	public static final String DESCRICAO_INVALIDA = "Descri��o inv�lida";
	public static final String TITULO_INVALIDO = "Titulo inv�lido";

	public LeilaoException(String s) {
		super(s);
	}
}
