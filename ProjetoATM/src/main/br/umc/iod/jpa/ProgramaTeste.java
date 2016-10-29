package br.umc.iod.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramaTeste {
	public static void main(String[] args) {
		// Criar EntityManagerFactory.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

		// Criar EntityManager.
		EntityManager em = emf.createEntityManager();

		MinhaEntidade objeto = new MinhaEntidade();
		objeto.setNumero(1982);
		objeto.setTexto("Texto ABCDEFZ");

		// Persistir objeto no banco.
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();

		// Fazer consulta ao banco.
		List<MinhaEntidade> lista = em.createQuery("FROM MinhaEntidade", MinhaEntidade.class).getResultList();
		for (MinhaEntidade selected : lista) {
			System.out.println("Objeto no banco: " + selected.getNumero() + ", " + selected.getTexto());
		}

		// Fechar EntityManager e EntityManagerFactory.
		em.close();
		emf.close();
	}
}
