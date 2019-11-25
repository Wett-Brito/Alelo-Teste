package br.com.testes.busca_diretor_e_filme_google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.massa.Massa;
import br.com.teste_geral.DriverFactory;
import br.com.teste_geral.DriverManager;
import br.com.util.EscritaELeituaUtil;

public class TestePesquisaNoGoogle {

    DriverManager driverManager;
    WebDriver driver;
	Massa setup = new Massa();
	
	PesquisaNoGooglePage pesquisaNoGooglePage = new PesquisaNoGooglePage();
    
    @Before
    public void before() 
    {
    	
    	setup.SetupMassa();
    	
        driverManager = DriverFactory.getManager();
        driver = driverManager.getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com.br/");
		
    }

    @After
    public void after() {
        driverManager.quitDriver();
    }

    @Test
    public void pesquisaNoGoogleEMostraQuantidadeDeResultados() 
    {    	      
    	EscritaELeituaUtil escritaELeituraUtil = new EscritaELeituaUtil(driver);
        for(int i = 0; i < Massa.getDiretor().filmes.size(); i++)
        {
        	escritaELeituraUtil.escreveNoCampo(pesquisaNoGooglePage.getCampoPesquisa(), (Massa.getDiretor().nome + " " + Massa.getDiretor().filmes.get(i).nome));
        	escritaELeituraUtil.enviar(pesquisaNoGooglePage.getCampoPesquisa());

			System.out.println(escritaELeituraUtil.pegaTexto(pesquisaNoGooglePage.getTxtTotalPesquisa()));
			
			escritaELeituraUtil.limpaCampo(pesquisaNoGooglePage.getCampoPesquisa());
			
			driver.manage().deleteAllCookies();
        }
		
    }	
}