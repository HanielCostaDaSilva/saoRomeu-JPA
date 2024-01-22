/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Prescricao;;

public class DAOPrescricao extends DAO<Prescricao> {

	
	public Prescricao read(Object chave) {
		try {
		
			TypedQuery<Prescricao> q = manager.createQuery("select a from Prescricao a where a.id=:a", Prescricao.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Prescricao> readAll() {
		TypedQuery<Prescricao> q = manager.createQuery("select a from Prescricao a order by a.id",
				Prescricao.class);
		return q.getResultList();
	}
}
