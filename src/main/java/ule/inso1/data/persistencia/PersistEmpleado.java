package ule.inso1.data.persistencia;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ule.inso1.data.entidades.Empleado;

public class PersistEmpleado {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(Empleado empleado) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(empleado);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void remove(Empleado empleado) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Empleado borrar = em.find(Empleado.class, empleado.getDni());
			em.remove(borrar);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void update(Empleado empleado) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Empleado actualizar = em.find(Empleado.class, empleado.getDni());
			
			actualizar.setNombre(empleado.getNombre());
			actualizar.setContrasenia(empleado.getContrasenia());
			actualizar.setFechaContra(empleado.getFechaContra());
			actualizar.setAdmin(empleado.getAdmin());
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public List<Empleado> recuperar() {
		
		emf = Persistence.createEntityManagerFactory("p-farmacia");
		em = emf.createEntityManager();
		List<Empleado> listaEmpleado = (List<Empleado>) em.createQuery("FROM Empleado").getResultList();
		return listaEmpleado;

	}
}
