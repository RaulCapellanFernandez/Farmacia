package ule.inso1.Farmacia.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ule.inso1.Farmacia.entidades.Empleado;

public class PersistEmpleado {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(Empleado empleado) {
		try{
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
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
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
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
			emf = Persistence.createEntityManagerFactory("p-peluqueria");
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
}
