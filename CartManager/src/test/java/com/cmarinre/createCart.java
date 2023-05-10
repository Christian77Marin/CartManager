package com.cmarinre;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.cmarinre.models.Cart;



public class createCart {

	@Test
	public void testCreateCart() {
		 Cart cart = new Cart(1);
		 assertNotNull(cart);
	}

}
