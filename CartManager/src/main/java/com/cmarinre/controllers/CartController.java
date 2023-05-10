package com.cmarinre.controllers;

import java.util.ArrayList;
import java.util.List;

import com.cmarinre.models.Cart;

public class CartController {

	public List<Cart> carts;
	
	public CartController() {
		this.carts = new ArrayList<Cart>();
	}
	
	//Devuelve el carro dandole una id
	public Cart getCart(int id) {
		return carts.stream().filter(cart -> cart.getId() == id).findFirst().orElse(null);
	}
	
	//Añade un carrito
	public void addCart(Cart cart) {
        carts.add(cart);
    }
	
	//Borra un carrito
	public void removeCart(Cart cart) {
        carts.remove(cart);
    }
	
	//Devuelve todo los carritos en una lista
	public List<Cart> getCarts() {
		return this.carts;
	}
	
	
}
