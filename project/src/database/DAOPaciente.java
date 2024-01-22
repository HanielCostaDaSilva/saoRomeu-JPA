/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Paciente;;

public class DAOPaciente extends DAO<Paciente> {

	
	public Paciente read(Object chave) {
		try {
		
			TypedQuery<Paciente> q = manager.createQuery("select a from Paciente a where a.cpf=:a", Paciente.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Paciente> readAll() {
		TypedQuery<Paciente> q = manager.createQuery("select a from Paciente a order by a.nome",
				Paciente.class);
		return q.getResultList();
	}
}
