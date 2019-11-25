package br.com.massa;

import java.util.ArrayList;

import br.com.classes_gerais.Diretor;
import br.com.classes_gerais.Filme;

public class Massa {
	
	static Diretor diretor;
	
	public void SetupMassa() 
	{
		ArrayList<Filme> filmes = new ArrayList<Filme>();
	
		boolean limiteFilmes = true;
		String nomeDiretor = JsonUtil.getValue("directors/name");
		String dataNasc = JsonUtil.getValue("directors/birthday");
		
		int j = 0;
		while (limiteFilmes)
		{
			String nomeFilme = JsonUtil.getValue("directors/movies/name", j);
			String dataLancamento = JsonUtil.getValue("directors/movies/releaseDate", j);
			
			if ((nomeFilme.isEmpty() || dataLancamento.isEmpty()) || (nomeFilme == null || dataLancamento == null)) 
			{
				limiteFilmes = false;
				break;
			}
			
			filmes.add(new Filme(nomeFilme, dataLancamento));
			j++;
		}
		
		diretor = new Diretor(nomeDiretor, dataNasc, filmes);
	}
	
	public static Diretor getDiretor() {
		return diretor;
	}
}
