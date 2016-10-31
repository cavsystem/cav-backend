package br.com.cavsystem.dominio.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConverter<E, D> {
	
	  public abstract D convertToDTO(E entity);

	  public abstract E convertToEntity(D dto);
	  
	  public List<D> convertToDTO(List<E> entities) {
	    List<D> list = new ArrayList<D>();
	    if (entities != null) {
	    	for(E e:entities){
	    		list.add(convertToDTO(e));
	    	}
	    }
	    return list;
	  }

	  public List<E> convertToEntity(List<D> dtos) {
	    List<E> list = new ArrayList<E>();
	    if (dtos != null) {
	    	for(D d:dtos){
	    		list.add(convertToEntity(d));
	    	}
	    }
	    return list;
	  }
	}