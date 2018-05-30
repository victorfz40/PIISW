package edu.ucam.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import edu.ucam.modelos.HibernateUtils;

public class AdminServiceImpl implements AdminService {
	
	private Session session = HibernateUtils.getSessionFactory().openSession();
	
	
	
	public <Entidad> boolean create(Class<Entidad> clase, Object objeto) {
		Transaction tx = session.beginTransaction();
		try{
			
			session.save(clase.cast(objeto));
			tx.commit();
			System.out.println("Creado un nuevo objeto de tipo " + clase.getName());
			return true;
		} catch(Exception e){
			System.out.println(e);
			if (tx!=null) tx.rollback();
		}

		return false;
	}
	
	public <Entidad> boolean update(Class<Entidad> clase, Object objeto){
		Transaction tx = session.beginTransaction();
		try{			
			session.update(clase.cast(objeto));
			tx.commit();
			System.out.println("Actualizado un nuevo objeto de tipo " + clase.getName());
			return true;
		}catch(Exception e){
			System.out.println(e);
			if (tx!=null) tx.rollback();
		}

		return false;
	}
	
	public <Entidad> boolean delete(Class<Entidad> clase, Object id) {
		Transaction tx = session.beginTransaction();
		try{			
			session.remove(session.find(clase, id));
			tx.commit();
			System.out.println("Eliminado un nuevo objeto de tipo " + clase.getName());
			return true;
		}catch(Exception e){
			System.out.println(e);
			if (tx!=null) tx.rollback();
		}

        return false;
	}
	

	@SuppressWarnings("unchecked")
	public <Entidad> List<Entidad> search(String entidad, String where) {
		try {
			Query query = session.createQuery("FROM "+ entidad +" WHERE " + where);
			return query.getResultList();
		}catch(Exception e){
			System.out.println(e);
		}

		return new ArrayList<Entidad>();
	}
	

	@SuppressWarnings("unchecked")
	public <Entidad> List<Entidad> search(String entidad, String where, int limit_ini, int limit_fin) {
		try {
			Query query = session.createQuery("FROM "+ entidad +" WHERE " + where);
			query.setFirstResult(limit_ini);
			query.setMaxResults(limit_fin);
			return query.getResultList();
		}catch(Exception e){
			System.out.println(e);
		}

		return new ArrayList<Entidad>();
	}
	
	
	@SuppressWarnings("unchecked")
	public <Entidad> List<Entidad> getListado(String entidad) {
		try {
			Query<Entidad> query = session.createQuery("FROM "+ entidad);
			return query.getResultList();
		}catch(Exception e){
			System.out.println(e);
		}

		return new ArrayList<Entidad>();
	}

	public <Entidad> Entidad getRegistroById(Class<Entidad> entidad, Object identificador){
		try{
			return entidad.cast(session.find(entidad, identificador));
		} catch (Exception e){
			System.out.println(e);
		}

		return null;
	}

	public <Entidad> List<Entidad> getRegistroByField(String entidad,
			String campo, Object valor) {
		String where = "";
		if (valor instanceof String) {
			where = campo + " like '" + valor + "'";
		} else {
			where = campo + " = " + valor;
		}
		try {
			return search(entidad, where);
		}catch(Exception e){
			System.out.println(e);
		}

		return null;
	}

	public <Entidad> List<Entidad> getLineasByCabecera(String entidadLineas, String columnaJoin, Object identificador){
		try{
			String where = "";
			if(identificador instanceof String){
				where = columnaJoin + " like '" + identificador + "'";
			} else {
				where = columnaJoin + " = " + identificador;
			}

			return search(entidadLineas, where);
		}catch(Exception e){
			System.out.println(e);
		}

		return null;
	}
	
	public int getTotalElementosSearch(String entidad, String where) {
		int resultado = 0;
		Query query = session.createQuery("select count(*) FROM "
				+ entidad + " WHERE " + where);
		try {
			resultado = ((Long) query.getSingleResult()).intValue();
		}catch(Exception e){
			System.out.println(e);
		}
		return resultado;
	}

	public int getTotalElementosListado(String entidad) {
		int resultado = 0;
		Query query = session.createQuery("select count(*) FROM "
				+ entidad);
		try {
			resultado = ((Long) query.getSingleResult()).intValue();
		}catch(Exception e){
			System.out.println(e);
		}
		return resultado;
	}

}
