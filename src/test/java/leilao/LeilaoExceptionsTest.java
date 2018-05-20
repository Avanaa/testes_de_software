package leilao;

import java.util.Calendar;

import org.junit.Test;

import exception.LeilaoException;
import negocio.LeilaoNegocio;

/**
 * 
 * @author Avana
 * Testa a cria��o do leil�o
 *
 */

public class LeilaoExceptionsTest {
	
	private Calendar inicio = Calendar.getInstance();
	private Calendar fim	= Calendar.getInstance();
	private Double valorInicial = 2000.00;

	@Test(expected = LeilaoException.class)
	public void testaLeilaoTituloVazio() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		new LeilaoNegocio("", "Descri��o", this.inicio, this.fim, this.valorInicial );	
	}

	@Test(expected = LeilaoException.class)
	public void testaLeilaoTituloNulo() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		new LeilaoNegocio(null, "Descri��o", this.inicio, this.fim, this.valorInicial );	
	}

	@Test(expected = LeilaoException.class)
	public void testaLeilaoDescricaoVazia() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		new LeilaoNegocio("T�tulo", "", this.inicio, this.fim, this.valorInicial );	
	}
	
	@Test(expected = LeilaoException.class)
	public void testaLeilaoDescricaoNula() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		new LeilaoNegocio("T�tulo", null, this.inicio, this.fim, this.valorInicial );	
	}

	@Test(expected = LeilaoException.class)
	public void testaLeilaoDataInicioInvalida() throws LeilaoException {
		
		this.inicio.set(2018, 4, 18, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		new LeilaoNegocio("Titulo", "Descri��o", this.inicio, this.fim, this.valorInicial );	
	}

	@Test(expected = LeilaoException.class)
	public void testaLeilaoDataInicioNula() throws LeilaoException {
		
		this.inicio.set(2018, 4, 18, 20, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		
		new LeilaoNegocio("Titulo", "Descri��o", null, this.fim, this.valorInicial );	
	}
	
	@Test(expected = LeilaoException.class)
	public void testaLeilaoDataFimInvalida() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 10, 20, 00, 00);
		
		new LeilaoNegocio("Titulo", "Descri��o", this.inicio, this.fim, this.valorInicial );	
	}
	
	@Test(expected = LeilaoException.class)
	public void testaLeilaoValorInicialNulo() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 10, 20, 00, 00);
		
		new LeilaoNegocio("Titulo", "Descri��o", this.inicio, this.fim, null );	
	}

	@Test(expected = LeilaoException.class)
	public void testaLeilaoValorInicialZero() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 10, 20, 00, 00);
		
		new LeilaoNegocio("Titulo", "Descri��o", this.inicio, this.fim, 0.0 );	
	}

	@Test(expected = LeilaoException.class)
	public void testaLeilaoValorInicialNegativo() throws LeilaoException {
		
		this.inicio.set(2018, 4, 20, 20, 00, 00);
		this.fim.set(2018, 4, 10, 20, 00, 00);
		
		new LeilaoNegocio("Titulo", "Descri��o", this.inicio, this.fim, -2000.00 );	
	}
}
