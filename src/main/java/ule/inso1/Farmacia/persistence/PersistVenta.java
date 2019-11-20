package ule.inso1.Farmacia.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ule.inso1.Farmacia.entidades.Venta;

public class PersistVenta {

	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(Venta venta) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(venta);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void remove(Venta venta) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Venta borrar = em.find(Venta.class, venta.getIdVenta());
			em.remove(borrar);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void update(Venta venta) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Venta actualizar = em.find(Venta.class, venta.getIdVenta());
			
			actualizar.setTotalVenta(venta.getTotalVenta());
			actualizar.setFechaVenta(venta.getFechaVenta());
			actualizar.setIdEmpleadoVenta(venta.getIdEmpleadoVenta());
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
}
