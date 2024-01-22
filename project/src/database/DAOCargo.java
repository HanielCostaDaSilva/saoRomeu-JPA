/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Cargo;

public class DAOCargo extends DAO<Cargo> {

	
	public Cargo read(Object chave) {
		try {
		
			TypedQuery<Cargo> q = manager.createQuery("select a from Cargo a where a.id=:a", Cargo.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Cargo> readAll() {
		TypedQuery<Cargo> q = manager.createQuery("select a from Cargo a order by a.nome",
				Cargo.class);
		return q.getResultList();
	}

}
