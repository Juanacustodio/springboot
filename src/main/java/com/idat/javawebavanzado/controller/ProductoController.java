package com.idat.javawebavanzado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idat.javawebavanzado.model.Producto;
import com.idat.javawebavanzado.service.ProductoService;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {

	 @Autowired
	 ProductoService productoService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("article_list");
	  List<Producto> articleList = productoService.listAll();
	  model.addObject("articleList", articleList);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/addProducto/", method=RequestMethod.GET)
	 public ModelAndView addProducto() {
	  ModelAndView model = new ModelAndView();
	  
	  Producto producto = new Producto();
	  model.addObject("productoForm", producto);
	  model.setViewName("producto_form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/updateProducto/{id}", method=RequestMethod.GET)
	 public ModelAndView editArticle(@PathVariable int id) {
	  ModelAndView model = new ModelAndView();
	  
	  Producto producto = productoService.findAllById(id);
	  model.addObject("productoForm", producto);
	  model.setViewName("producto_form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/saveProducto", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("productoForm") Producto producto) {
		 productoService.insert(producto);
	  
	  return new ModelAndView("redirect:/producto/list");
	 }
	 
	 @RequestMapping(value="/deleteProducto/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id) {
		 productoService.delete(id);
	  
	  return new ModelAndView("redirect:/producto/list");
	 }
}