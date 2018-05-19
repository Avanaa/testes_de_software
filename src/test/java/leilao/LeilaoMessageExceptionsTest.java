package leilao;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import exception.LeilaoException;
import negocio.LeilaoNegocio;

/**
 * 
 * @author Avana
 * Testa mensagens de erro na criação do leilão
 */

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

	@Test
	public void testaLeilaoDescricaoNulaMsg(){
		
		this.inicio.set(2018, 4, 19, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("Título", null, this.inicio, this.fim, this.valorInicial );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.DESCRICAO_INVALIDA, e.getMessage());
		}
	}
	

	@Test
	public void testaLeilaoDataInicioInvalidaMsg(){
		
		this.inicio.set(2018, 4, 18, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("Titulo", "Descrição", this.inicio, this.fim, this.valorInicial );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.DATA_INICIO_INVALIDA, e.getMessage());
		}	
	}

	@Test
	public void testaLeilaoDataFimInvalida() {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("Titulo", "Descrição", this.inicio, this.fim, this.valorInicial );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.DATA_FIM_INVALIDA, e.getMessage());
		}	
	}
	
	@Test
	public void testaLeilaoValorInicialNulo(){
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("Titulo", "Descrição", this.inicio, this.fim, null );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.VALOR_INICIAL_INVALIDO, e.getMessage());
		}	
	}

	@Test
	public void testaLeilaoValorInicialZero() {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("Titulo", "Descrição", this.inicio, this.fim, 0.0 );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.VALOR_INICIAL_INVALIDO, e.getMessage());
		}	
	}

	@Test
	public void testaLeilaoValorInicialNegativo() {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		try {
			new LeilaoNegocio("Titulo", "Descrição", this.inicio, this.fim, -2000.00 );
		} catch (LeilaoException e) {
			assertEquals(LeilaoException.VALOR_INICIAL_INVALIDO, e.getMessage());
		}	
	}
}
