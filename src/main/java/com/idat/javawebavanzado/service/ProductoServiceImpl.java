package com.idat.javawebavanzado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.javawebavanzado.model.Producto;
import com.idat.javawebavanzado.repository.ProductoRepository;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public void insert(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(int id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		productoRepository.deleteAll();
		
	}

	@Override
	public Producto findAllById(int id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public List<Producto> listAll() {
		return (List<Producto>) productoRepository.findAll();
	}
	
	public long count() {
		return productoRepository.count();
	}

}
