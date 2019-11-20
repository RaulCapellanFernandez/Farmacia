package ule.inso1.Farmacia.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ule.inso1.Farmacia.entidades.VentaAlmacen;

public class PersistAlmacenVenta {

	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(VentaAlmacen ventaAlmacen) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(ventaAlmacen);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void remove(VentaAlmacen ventaAlmacen) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			VentaAlmacen borrar = em.find(VentaAlmacen.class, ventaAlmacen.getIdVentaAlmacen());
			em.remove(borrar);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void update(VentaAlmacen ventaAlmacen) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			VentaAlmacen actualizar = em.find(VentaAlmacen.class, ventaAlmacen.getIdVentaAlmacen());
			
			actualizar.setIdVenta(ventaAlmacen.getIdVenta());
			actualizar.setIdAlmacen(ventaAlmacen.getIdAlmacen());
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
}