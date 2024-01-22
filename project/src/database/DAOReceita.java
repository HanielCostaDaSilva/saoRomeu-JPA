/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Receita;

public class DAOReceita extends DAO<Receita> {

	
	public Receita read(Object chave) {
		try {
		
			TypedQuery<Receita> q = manager.createQuery("select a from Receita a where a.id=:a", Receita.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Receita> readAll() {
		TypedQuery<Receita> q = manager.createQuery("select a from Receita a order by a.nome",
				Receita.class);
		return q.getResultList();
	}
}
