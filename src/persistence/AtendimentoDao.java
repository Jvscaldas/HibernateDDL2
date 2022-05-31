package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Atendente;
import model.Atendimento;

public class AtendimentoDao implements IAtendimentoDao {

	private SessionFactory sf;

	public AtendimentoDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Atendimento atend) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(atend);
		transaction.commit();

	}

	@Override
	public Atendimento selectOne(Atendimento atend) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT a.cpf_cliente, a.id_funcionario, a.dt_atendimento, a.hr_atendimento ");
		buffer.append("FROM atendimento a, cliente c, atendente atend ");
		buffer.append("INNER JOIN cliente ON c.cpf_cliente = a.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atend.id_funcionario = a.id_funcionario ");
		buffer.append("WHERE a.cpf_cliente = ?1 ");
		buffer.append("AND a.id_funcionario = ?2 ");
		buffer.append("AND a.dt_atendimento = ?3 ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		query.setParameter("cpf_cliente", atend.getCliente());
		query.setParameter("id_funcionario", atend.getFuncionario());
		query.setParameter("dt_atendimento", atend.getDt_atendimento());

		return atend;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atendimento> selectOneCliente(Atendimento atend) {
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();

		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT a.cpf_cliente, a.id_funcionario, a.dt_atendimento, a.hr_atendimento ");
		buffer.append("FROM atendimento a, cliente c, atendente atend ");
		buffer.append("INNER JOIN cliente ON c.cpf_cliente = a.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atend.id_funcionario = a.id_funcionario ");
		buffer.append("WHERE a.cpf_cliente = ?1 ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		query.setParameter("cpf_cliente", atend.getCliente());

		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Atendimento at = new Atendimento();
			at.setCliente(obj[0].toString());
			at.setFuncionario(obj[1].toString());
			at.setDt_atendimento(obj[2].toString());
			at.setHr_atendimento(obj[3].toString());

			atendimentos.add(at);
		}

		return atendimentos;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atendimento> selectOneAtendente(Atendimento atend) {
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();

		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT a.cpf_cliente, a.id_funcionario, a.dt_atendimento, a.hr_atendimento ");
		buffer.append("FROM atendimento a, cliente c, atendente atend ");
		buffer.append("INNER JOIN cliente ON c.cpf_cliente = a.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atend.id_funcionario = a.id_funcionario ");
		buffer.append("WHERE a.id_funcionario = ?1 ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		query.setParameter("id_funcionario", atend.getFuncionario());

		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Atendimento at = new Atendimento();
			at.setCliente(obj[0].toString());
			at.setFuncionario(obj[1].toString());
			at.setDt_atendimento(obj[2].toString());
			at.setHr_atendimento(obj[3].toString());

			atendimentos.add(at);
		}

		return atendimentos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atendimento> selectAll() {
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();

		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT a.cpf_cliente, a.id_funcionario, a.dt_atendimento, a.hr_atendimento ");
		buffer.append("FROM atendimento a, cliente c, atendente atend ");
		buffer.append("INNER JOIN cliente ON c.cpf_cliente = a.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atend.id_funcionario = a.id_funcionario ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());

		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Atendimento at = new Atendimento();
			at.setCliente(obj[0].toString());
			at.setFuncionario(obj[1].toString());
			at.setDt_atendimento(obj[2].toString());
			at.setHr_atendimento(obj[3].toString());

			atendimentos.add(at);
		}

		return atendimentos;
	}

}
