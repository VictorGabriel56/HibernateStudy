package Control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Aluno;

public class AlunoController {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoController() {
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
	}
	
	public void save(Aluno a) {
		try{em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		emf.close();
		} catch (Exception e) {
			System.err.print("Save Error");
		}
		
	}
	
	
	public void delete(Aluno a) {
		try{
		em.getTransaction().begin();
		Query q = em.createNativeQuery("DELETE FROM aluno WHERE martricula = "+a.getMatricula());
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
		}catch (Exception e) {
			System.err.println("Delete Error");
		}
	}
	
	
	public void deleteWithUnique(String matricula) {
		try{			
		em.getTransaction().begin();
		Query q = em.createNativeQuery("DELETE FROM aluno WHERE matricula = "+matricula);
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
		} catch (Exception e) {
			System.err.println("Delete With Unique (cadidate Key) Error");
		}
	}
	
	public List<Aluno> list(){
		try{
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT aluno FROM Aluno aluno");
			List<Aluno> list = q.getResultList();
			em.getTransaction().commit();
			emf.close();
			return list;
		
		}catch (Exception e) {
			System.err.println("List Error");
			return list();
		}
	}
	
}