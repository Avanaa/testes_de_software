package exception;

public class LanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USUARIO_INVALIDO = "Usu�rio inv�lido";
	public static final String VALOR_INVALIDO = "Valor inv�lido";
	
	public LanceException(String s) {
		super(s);
	}
}
