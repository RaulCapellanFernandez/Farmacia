package ule.inso1.data.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ule.inso1.data.entidades.Almacen;
import ule.inso1.data.entidades.Empleado;

public class PersistAlmacen {

	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction tx = null;
	
	public void save(Almacen almacen) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(almacen);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void remove(Almacen almacen) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Almacen borrar = em.find(Almacen.class, almacen.getIdAlmacen());
			em.remove(borrar);
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public void update(Almacen almacen) {
		try{
			emf = Persistence.createEntityManagerFactory("p-farmacia");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Almacen actualizar = em.find(Almacen.class, almacen.getIdAlmacen());
			
			actualizar.setNombre(almacen.getNombre());
			actualizar.setCantidad(almacen.getCantidad());
			actualizar.setPrecio(almacen.getPrecio());
			
			tx.commit();		
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public List<Almacen> recuperar() {
		
		emf = Persistence.createEntityManagerFactory("p-farmacia");
		em = emf.createEntityManager();
		List<Almacen> listaAlmacen = (List<Almacen>) em.createQuery("FROM Almacen").getResultList();
		return listaAlmacen;

	}
}
