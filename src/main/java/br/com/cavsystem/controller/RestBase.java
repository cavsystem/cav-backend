package br.com.cavsystem.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cavsystem.exception.BusinessException;


@Controller
@CrossOrigin(maxAge = 3600,origins="*")

public abstract class RestBase<T, K>{

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public T obter(@PathVariable("id") K id) throws BusinessException {
		return acaoObter(id);
	}

	protected abstract T acaoObter(K id) throws BusinessException;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<T> listar() {
		return acaoListar();
	}

	protected abstract List<T> acaoListar();


	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public T incluir(@RequestBody T t) throws BusinessException {
		return acaoIncluir(t);
	}

	protected abstract T acaoIncluir(T t) throws BusinessException;

    @RequestMapping(method = RequestMethod.PUT)
	public T atualizar(@RequestBody T t) throws BusinessException {
		return acaoAtualizar(t);
	}

	protected abstract T acaoAtualizar(T t) throws BusinessException;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody void remover(@PathVariable("id") K id) throws BusinessException {
		acaoRemover(id);
	}

	protected abstract void acaoRemover(K id) throws BusinessException;
}