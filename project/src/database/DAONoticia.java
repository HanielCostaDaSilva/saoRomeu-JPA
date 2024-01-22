/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package database;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Noticia;

public class DAONoticia extends DAO<Noticia> {

	/**
	 * Busca uma Noticia pelo título, convertendo-o para maiúsculas.
	 *
	 * @param chave Título da notícia a ser buscada.
	 * @return A Noticia encontrada ou null se não encontrada.
	 */
	public Noticia readByTitle(String title) {
		try {
			String titulo = (String) title;
			//titulo = titulo.toUpperCase();
			
			TypedQuery<Noticia> q = manager.createQuery("SELECT n FROM Noticia n WHERE n.titulo LIKE :t", Noticia.class);
			
			q.setParameter("t", "%"+ titulo + "%");
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Noticia read(Object chave) {
		try {
		
			TypedQuery<Noticia> q = manager.createQuery("select n from Noticia n where n.id=:t", Noticia.class);
			q.setParameter("t", chave);
			return q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * Busca todas as Noticias com a lista de Assuntos associada.
	 *
	 * @return Lista de Noticias.
	 */
	public List<Noticia> readAll() {
		TypedQuery<Noticia> q = manager.createQuery(
				"select n from Noticia n LEFT JOIN FETCH n.listaAssuntos order by n.titulo", Noticia.class);
	
		return q.getResultList();
	}

	// --------------------------------------------
	// consultas
	// --------------------------------------------
	public List<Noticia> readAll(String caracteres) {
		caracteres = caracteres.toUpperCase();

		TypedQuery<Noticia> q = manager.createQuery(
				"select n from Noticia n LEFT JOIN FETCH n.listaAssuntos where n.titulo like :x  order by n.titulo",
				Noticia.class);
		q.setParameter("x", "%" + caracteres + "%");
		return q.getResultList();
	}

	public List<Noticia> readByNAssuntos(int n) {
		TypedQuery<Noticia> q = manager.createQuery(
				"select n from Noticia n JOIN FETCH n.listaAssuntos where SIZE(n.listaAssuntos) = :x", Noticia.class);
		q.setParameter("x", n);
		return q.getResultList();
	}

	public List<Noticia> getNoticiasPorDataPublicacao(String data) {
	    TypedQuery<Noticia> q = manager.createQuery(
	            "SELECT n FROM Noticia n WHERE n.dataPublicacao LIKE :data", Noticia.class);
	    q.setParameter("data", "%" + data + "%");
	    return q.getResultList();
	}

	public boolean temAssuntos(String nome) {
		try {
			nome = nome.toUpperCase();

			Query q = manager.createQuery(
					"select count(a) from Noticia N join n.listaAssuntos a where n.titulo = :x and a.id like :y");
			q.setParameter("x", nome);
			q.setParameter("y", "1%");
			long cont = (Long) q.getSingleResult();
			return cont > 0;
		} catch (NoResultException e) {
			return false;
		}
	}

}
