package ule.inso1.data.persistencia;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ule.inso1.data.entidades.Empleado;
import ule.inso1.data.entidades.VentaAlmacen;

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
			em.flush();
			em.clear();
			
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
			
			actualizar.setAlmacen(ventaAlmacen.getAlmacen());
			actualizar.setVenta(ventaAlmacen.getVenta());
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public List<VentaAlmacen> recuperar() {
		
		emf = Persistence.createEntityManagerFactory("p-farmacia");
		em = emf.createEntityManager();
		List<VentaAlmacen> listaVAlmacen = (List<VentaAlmacen>) em.createQuery("FROM VentaAlmacen").getResultList();
		return listaVAlmacen;

	}

}