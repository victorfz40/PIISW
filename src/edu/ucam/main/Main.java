package edu.ucam.main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.ucam.modelos.Categorias;
import edu.ucam.modelos.HibernateUtils;


public class Main {

	private static Session session;
	public static void main(String[] args) {
		session=HibernateUtils.getSessionFactory().openSession();
		System.out.println(session.byId( Categorias.class ).load(7));
		//System.out.println(session.createCriteria() ;//( Categorias.class ).load(7));
		Transaction tx=session.beginTransaction();
		creaCategoria("Cat1");
		//creaCategoria("Cat2");
		
		tx.commit();
		session.close();
		System.exit(0);
	}
	
	public static void creaCategoria(String nombre){
		Categorias o=new Categorias(nombre);
		session.save(o);

		try {
			Categorias c=(Categorias)session.load(Categorias.class, 6);
			System.out.println(c);
			//session.delete(c);
			//System.out.println(session.createCriteria(Categorias.class).list());
			//System.out.println(session.byId( Categorias.class ).load(7));
			//System.out.println(session.byId( Categorias.class));
			//entityManager.find( Author.class, authorId );
			
		} catch (Exception e) {
			System.out.println("No se ha encontrado el objeto");
		}
	}

}
