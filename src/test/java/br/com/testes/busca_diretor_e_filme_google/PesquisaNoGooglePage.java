package br.com.testes.busca_diretor_e_filme_google;

import org.openqa.selenium.By;

public class PesquisaNoGooglePage {

	private By campoPesquisa = By.xpath("//*[@name='q']");
	private By txtTotalPesquisa = By.xpath("//*[@id='resultStats']");
	
	public By getCampoPesquisa() {
		return campoPesquisa;
	}
	
	public By getTxtTotalPesquisa() {
		return txtTotalPesquisa;
	}
			
}
