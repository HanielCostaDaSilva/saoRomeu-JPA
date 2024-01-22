/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Telefone;

public class DAOTelefone extends DAO<Telefone> {

	
	public Telefone read(Object chave) {
		try {
		
			TypedQuery<Telefone> q = manager.createQuery("select a from Telefone a where a.id=:a", Telefone.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Telefone> readAll() {
		TypedQuery<Telefone> q = manager.createQuery("select a from Telefone a order by a.nome",
				Telefone.class);
		return q.getResultList();
	}
}
