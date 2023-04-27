package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Docente;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladorDocente {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("profesoresymaterias");

	public static List<Docente> findLikeNombre(String descripcion) {
		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM docente where nombreCompleto like ?", Docente.class);
		q.setParameter(1, "%" + descripcion + "%");

		List<Docente> l = (List<Docente>) q.getResultList();

		em.close();
		return l;

	}
}
