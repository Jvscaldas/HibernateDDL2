package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Entregador;

public class EntregadorDao implements IObjDao<Entregador> {

	private SessionFactory sf;

	public EntregadorDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Entregador t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(t);
		transaction.commit();

	}

	@Override
	public void modifica(Entregador t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(t);
		transaction.commit();

	}

	@Override
	public void remove(Entregador t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(t);
		transaction.commit();

	}

	@Override
	public Entregador busca(Entregador t) {
		EntityManager entityManager = sf.createEntityManager();
		t = entityManager.find(Entregador.class, t.getId_funcionario());
		return t;
	}

	@Override
	public List<Entregador> lista() {
		List<Entregador> entregadores = new ArrayList<Entregador>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT numero_cnh, categoria_cnh ");
		buffer.append("FROM entregador ");
		buffer.append("ORDER BY numero_cnh");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Entregador e = new Entregador();
			e.setNumero(obj[0].toString());
			e.setCategoria(obj[1].toString());

			entregadores.add(e);
		}
		
		return entregadores;
	}

}
