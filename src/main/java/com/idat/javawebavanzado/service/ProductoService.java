package com.idat.javawebavanzado.service;

import java.util.List;

import com.idat.javawebavanzado.model.Producto;

public interface ProductoService {
	public void insert(Producto producto);
	public void update(Producto producto);
	public void delete(int id);
	public void deleteAll();
	public Producto findAllById(int id);
	public List<Producto> listAll();
	
	public long count();
}
