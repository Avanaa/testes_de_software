package exception;

public class LanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USUARIO_INVALIDO = "Usuário inválido";
	public static final String VALOR_INVALIDO = "Valor inválido";
	
	public LanceException(String s) {
		super(s);
	}
}
