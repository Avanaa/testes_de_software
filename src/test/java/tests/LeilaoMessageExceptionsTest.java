package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import exception.LeilaoException;
import negocio.LeilaoNegocio;

public class LeilaoMessageExceptionsTest {

	private Calendar inicio = Calendar.getInstance();
	private Calendar fim	= Calendar.getInstance();
	private Double valorInicial = 2000.00;

	@Test
	public void testaLeilaoTituloVazioMsg(){
		
		this.inicio.set(2018, 4, 19, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("", "Descrição", this.inicio, this.fim, this.valorInicial );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.TITULO_INVALIDO, e.getMessage());
		}	
	}
		
	@Test
	public void testaLeilaoTituloNuloMsg() {
		
		this.inicio.set(2018, 4, 19, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio(null, "Descrição", this.inicio, this.fim, this.valorInicial );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.TITULO_INVALIDO, e.getMessage());
		}	
	}

	@Test
	public void testaLeilaoDescricaoVaziaMsg(){
		
		this.inicio.set(2018, 4, 19, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("Título", "", this.inicio, this.fim, this.valorInicial );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.DESCRICAO_INVALIDA, e.getMessage());
		}	
	}
	
}
