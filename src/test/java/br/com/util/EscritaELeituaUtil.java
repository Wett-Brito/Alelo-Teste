package br.com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.teste_geral.DriverFactory;
import br.com.teste_geral.DriverManager;

public class EscritaELeituaUtil {
	
    DriverManager driverManager = DriverFactory.getManager();
    WebDriver driver;
	
    public EscritaELeituaUtil(WebDriver driver) {
    	this.driver = driver;
	}
    
    public void escreveNoCampo(By by, String texto) {
    	esperaEstarVisivel(by);
    	buscaElemento(by).sendKeys(texto);
    }
    
    public void limpaCampo(By by) {
    	esperaEstarVisivel(by);
    	buscaElemento(by).clear();
    }
    
	public String pegaTexto (By by) {
    	esperaEstarVisivel(by);
		return buscaElemento(by).getText();	
	}
	
	public WebElement buscaElemento(By by) {
		return driver.findElement(by);
	}
	
	public void enviar(By by) {
		buscaElemento(by).submit();
	}
	
	public void esperaPadrao(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
	
	public void esperaEstarVisivel(By by) {
		for(int i = 0; i < 60; i++)
		{
			if(buscaElemento(by).isDisplayed()) 
			{
				break;
			}
			
			esperaPadrao();
		}
	}
	
}
