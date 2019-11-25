package br.com.classes_gerais;

import java.util.ArrayList;

public class Diretor
{
	public String nome;
	public String dataNascimento;
	public ArrayList<Filme> filmes = new ArrayList<Filme>();
	
	public Diretor (String nome, String dataNascimento, ArrayList<Filme> filmes)
	{
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.filmes = filmes;
	}	
	
	
	public String getNome() {
		return nome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}	
	
}