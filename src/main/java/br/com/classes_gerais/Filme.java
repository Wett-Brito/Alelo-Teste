package br.com.classes_gerais;

public class Filme
{
	public String nome;
	public String dataLancamento;
	
	public Filme (String nome, String dataLancamento)
	{
		this.nome = nome;
		this.dataLancamento = dataLancamento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String dataLnacamento() {
		return dataLancamento;
	}
}