package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Atendente;

public class AtendenteDao implements IObjDao<Atendente> {

	private SessionFactory sf;

	public AtendenteDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Atendente t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(t);
		transaction.commit();

	}

	@Override
	public void modifica(Atendente t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(t);
		transaction.commit();

	}

	@Override
	public void remove(Atendente t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(t);
		transaction.commit();

	}

	@Override
	public Atendente busca(Atendente t) {
		EntityManager entityManager = sf.createEntityManager();
		t = entityManager.find(Atendente.class, t.getId_funcionario());
		return t;
	}

	@Override
	public List<Atendente> lista() {
		List<Atendente> atendentes = new ArrayList<Atendente>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT email_atendente, hr_entrada, hr_saida ");
		buffer.append("FROM atendente ");
		buffer.append("ORDER BY email_atendente");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Atendente a = new Atendente();
			a.setEmail(obj[0].toString());
			a.setHr_entrada(obj[1].toString());
			a.setHr_saida(obj[2].toString());

			atendentes.add(a);
		}

		return atendentes;
	}

}
