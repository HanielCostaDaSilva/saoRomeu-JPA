/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Funcionario;

public class DAOFuncionario extends DAO<Funcionario> {

	
	public Funcionario read(Object chave) {
		try {
		
			TypedQuery<Funcionario> q = manager.createQuery("select a from Funcionario a where a.matricula=:a", Funcionario.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Funcionario> readAll() {
		TypedQuery<Funcionario> q = manager.createQuery("select a from Funcionario a order by a.name",
				Funcionario.class);
		return q.getResultList();
	}
}
