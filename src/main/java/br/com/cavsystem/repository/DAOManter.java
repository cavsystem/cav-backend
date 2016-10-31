package br.com.cavsystem.repository;

import java.util.List;


	public interface DAOManter<T, K> extends DAO<T> {

		T obter(K chave);
		T primeiro();
		T incluir(T entidade);
		T atualizar(T entidade);
		T reatachar(T entidade);
		void atualizar(List<T> lista);
		void incluir(List<T> lista);
		void excluir(K chave);
		List<T> listar();
		Long getMaxID();
		boolean isVazio();
	}
