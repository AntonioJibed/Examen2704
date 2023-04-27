package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;

public class ControladorAsignatura {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("profesoresymaterias");

	public static List<Asignatura> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from asignatura", Asignatura.class);
		List<Asignatura> lista = (List<Asignatura>) q.getResultList();
		em.close();
		return lista;
	}

	public static void update(Asignatura a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		System.out.println("He realizado la modificacion");
		em.getTransaction().commit();
		em.close();
	}

	public static void insert(Asignatura a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		System.out.println("He realizado la inserccion");
		em.getTransaction().commit();
		em.close();
	}
}
