/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Remedio;

public class DAORemedio extends DAO<Remedio> {
	
	public Remedio read(Object chave) {
		try {
		
			TypedQuery<Remedio> q = manager.createQuery("select a from Remedio a where a.id=:a", Remedio.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Remedio> readAll() {
		TypedQuery<Remedio> q = manager.createQuery("select a from Remedio a order by a.nome",
				Remedio.class);
		return q.getResultList();
	}

}
