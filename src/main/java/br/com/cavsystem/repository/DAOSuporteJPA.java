package br.com.cavsystem.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public abstract class DAOSuporteJPA<T, K> implements DAOManter<T, K> {

	@PersistenceContext
	protected EntityManager persistencia;

	protected Class<T> entityClass;

        @Override
	public T obter(K chave) {
		return persistencia.find(getEntityClass(), chave);
	}

        @Override
	public T incluir(T entidade) {		
		persistencia.persist(entidade);
		persistencia.flush();
		return entidade;
	}

        @Override
	public void incluir(List<T> lista) {
		for (T entidade : lista) {
			incluir(entidade);
		}
	}

        @Override
	public T atualizar(T entidade) {
		T ret = persistencia.merge(entidade);
		persistencia.flush();
		return ret;
	}

        @Override
	public void atualizar(List<T> lista) {
		for (T entidade : lista) {
			atualizar(entidade);
		}
	}

        @Override
	public T reatachar(T entidade) {
		return persistencia.merge(entidade);
	}
        
   public Long getMaxID() {
	   StringBuilder queryBuilder = new StringBuilder("SELECT MAX(e.id) FROM " + getEntityClass().getSimpleName() + " e ");
	   String sql = queryBuilder.toString();
	   return (Long) persistencia.createQuery(sql).getSingleResult();
   }

        @Override
	public void excluir(K chave) {
		T entidade = obter(chave);

		if (entidade != null) {
			persistencia.remove(entidade);
			persistencia.flush();
		}
	}

	@SuppressWarnings("unchecked")
        @Override
	public List<T> listar() {
		String sql = listarJPAQL();

		return persistencia.createQuery(sql).getResultList();
	}

        @Override
	public T primeiro() {
		Iterator<T> it = listar().iterator();

		if (it.hasNext()) {
			return it.next();
		}

		return null;
	}

	protected String listarJPAQL() {
		StringBuilder queryBuilder = new StringBuilder("from " + getEntityClass().getSimpleName());
		String sql = queryBuilder.toString();

		DefaultOrder order = getEntityClass().getAnnotation(DefaultOrder.class);
		if (order != null) {
			queryBuilder.append(" order by ");
			for (String column : order.columns()) {
				queryBuilder.append(column + ", ");
			}

			sql = queryBuilder.substring(0, queryBuilder.length() - 2);
		}
		return sql;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				entityClass = (Class<T>) paramType.getActualTypeArguments()[0];
			} else {
				throw new IllegalArgumentException("Erro ao tentar obter o tipo de classe da entidade");
			}
		}

		return entityClass;
	}

    @Override
	public boolean isVazio() {
		return listar().isEmpty();
	}

}
