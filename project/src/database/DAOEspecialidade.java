/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Especialidade;

public class DAOEspecialidade extends DAO<Especialidade> {

	public Especialidade read(Object chave) {
		try {
		
			TypedQuery<Especialidade> q = manager.createQuery("select a from Especialidade a where a.id=:a", Especialidade.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Especialidade> readAll() {
		TypedQuery<Especialidade> q = manager.createQuery("select a from Especialidade a order by a.nome",
				Especialidade.class);
		return q.getResultList();
	}

}
