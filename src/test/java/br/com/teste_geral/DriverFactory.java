package br.com.teste_geral;

public class DriverFactory {
	
    public static DriverManager getManager() {

        DriverManager driverManager = new ChromeDriverManager();

        return driverManager;

    }
}
