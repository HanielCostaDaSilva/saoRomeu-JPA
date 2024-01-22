/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Assunto;
import model.Noticia;

public class DAOAssunto extends DAO<Assunto> {

	public Assunto read(Object chave) {
		try {
			String id = (String) chave;
			TypedQuery<Assunto> q = manager.createQuery("select a from Assunto a where a.nome = :n ", Assunto.class);
			q.setParameter("n", id);

			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Assunto read(int chave) {
		try {
		
			TypedQuery<Assunto> q = manager.createQuery("select a from Assunto a where a.id=:a", Assunto.class);
			q.setParameter("a", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}


	// sobrescrever o metodo readAll da classe DAO
	public List<Assunto> readAll() {
		TypedQuery<Assunto> q = manager.createQuery("select a from Assunto a order by a.nome",
				Assunto.class);
		return q.getResultList();
	}

	// --------------------------------------------
	// consultas
	// --------------------------------------------

	public List<Assunto> getAssuntosPorQuantidadeNoticia(int quantidade) {
		TypedQuery<Assunto> q = manager.createQuery(
				"select a from Assunto a where SIZE(a.listaNoticia) = :x", Assunto.class);
		q.setParameter("x", quantidade);
		return q.getResultList();
	}

	
	public List<Noticia> getnoticiasPorAssunto(String assuntoNome) {
		TypedQuery<Noticia> q = manager.createQuery(
				"select a.listaNoticia from Assunto a where a.nome like :x", Noticia.class);
				q.setParameter("x", "%" + assuntoNome + "%");
		return q.getResultList();
	}
}
