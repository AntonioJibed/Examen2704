package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;



public class ControladorAsignaturaPorDocente {

	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresyasignaturas");
	public static Asignaturaspordocente asignaturaDocente(Asignatura a, Docente d) {
		Asignaturaspordocente apd = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query q = em.createNativeQuery("select * from asignaturapordocente where idDocente = "+d.getId()+" and idAsignatura = "+a.getId(), Asignaturaspordocente.class);
			apd = (Asignaturaspordocente) q.getSingleResult();
		
		} catch (Exception e2) {
		}
		em.close();
		return apd;
	}
	
	
	public static void update(Asignaturaspordocente apd) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(apd);
		System.out.println("He realizado la modificacion");
		em.getTransaction().commit();
		em.close();
	}
	
	public static void insert(Asignaturaspordocente apd) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(apd);
		System.out.println("He realizado la inserccion");
		em.getTransaction().commit();
		em.close();
	}
}
