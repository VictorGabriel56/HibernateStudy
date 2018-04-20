package View;

import java.util.List;

import Control.AlunoController;
import Model.Aluno;

public class Teste {
	
	public static void main (String[] args) {
		
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		
		a1.setNome("A");
		a1.setIdade(10);
		a1.setMatricula("22");
		
		a2.setNome("B");
		a2.setIdade(10);
		a2.setMatricula("22");
		
		a3.setNome("c");
		a3.setIdade(55);
		a3.setMatricula("20162022009");
		
		AlunoController con = new AlunoController();
		
		//Metodo Salvar
		con.save(a3);
		
		//Metodo Deletar
		con.delete(a2);
		
		//Metodo de deletar com a Chave candidata
		con.deleteWithUnique("20162022009");
		
		
		//Metodo de Listar
		List<Aluno> alunos =  con.list();		
		
		
		// for para exibir a QUERY de listar
		for (int i = 0; i < alunos.size(); i++) {
			System.out.println("\nNome: "+alunos.get(i).getNome()+" Idade: " +alunos.get(i).getIdade()+" Matricula: "+alunos.get(i).getMatricula());
		}
		
		
	}

}
