package com.cmarinre.controllers;

import java.util.Scanner;

import com.cmarinre.inicio.UserInterface;
import com.cmarinre.models.Cart;
import com.cmarinre.models.Product;



public class MenuController {

	
	private static final CartController cartController= new CartController();
    private static final Scanner read = new Scanner(System.in);
    private int option = 1;
	
	
	private static final UserInterface ui = new UserInterface();
     
	//Muestra el Menu
	public void ShowMenu(){
		//Clase hecha para simplificar el codigo
        ui.Menu();

        option = read.nextInt();
    }
	
	//Funcion para limpiar la consola
	public void clsEclipse() {
		//puesto que la consola de eclipse no soporta ANSI limpiamos la consola de esta manera
		 for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	//Maneja los inputs del usuario que se muestran por consola
	public void SwitchManager() {
		 while(true) {
			 clsEclipse();
			 ShowMenu();
			 
			 switch (option) {
             case 1:
            	 
            	 clsEclipse();
            	 
                 createCart();
                 
                 read.nextLine();
                 break;
             case 2:
				 clsEclipse();
				 addProductToCart();
				 read.nextLine();
                 break;
             case 3:

				 clsEclipse();
				 viewCart();
				 read.nextLine();

                 break;
             case 4:
            	 clsEclipse();
                 removeCart();
                 read.nextLine();
                 break;
             case 5:
                 System.out.println("Saliendo...");
                 System.exit(0);
                 break;
             default:
                 System.out.println("Opción inválida");
                 break;
			 }
		 }
	}
	
	//Crea un carro
	 private static void createCart() {
		 
		 //Creamos una id no existente
		 	int id = cartController.getCarts().size() + 1;
		 	while(cartController.getCart(id) != null) {
		 		id++;
		 	}
		 	//Se crea el carro
	        Cart cart = new Cart(id);
	        cart.startTimeoutThread(); //Iniciamos el Hilo para que se elimine el carro en caso de inactividad
	        cartController.addCart(cart); //Añadimos el carro a la lista de Carros
	        System.out.println("Carrito creado con ID " + cart.getId());
	        System.out.println("Presione Enter para volver al menú");
            read.nextLine();
	    }

	    private static void viewCart() {
	        System.out.print("Ingrese el ID del carrito: ");
	        int id = read.nextInt();
	        Cart cart = cartController.getCart(id); //Cogemos el id del carro y comprobamos  que exista
	        if (cart != null) {
	            System.out.println("=== Carrito ID " + cart.getId() + " ===");
	            
	            //Mostramos todos los productos que hay en el carro
	            System.out.println(cart.getProperties());
	            
	        } else {
	            System.out.println("Carrito no encontrado");
	        }
	        
	        System.out.println("Presione Enter para volver al menú");
            read.nextLine();
	        
	    }
	    //Añade un producto a un carrito especifico
	    private static void addProductToCart() {
	        System.out.print("Ingrese el ID del carrito: ");
	        int id = read.nextInt();
	        Cart cart = cartController.getCart(id); //comprobamos que el carrito existe
	        if (cart != null) {
	        	int productId = 0;
	        	cart.resetTimeoutThread(); //Reseteamos el hilo por inactividad
	        	
	        	do {
	        		System.out.print("Ingrese el ID del producto: ");
		            productId = read.nextInt();
	        	} while (cart.productExist(productId)); //Comprobamos que el productId sea unico en el carrito
	        	
	            
	            
	            read.nextLine(); 
	            System.out.print("Ingrese la descripción del producto: ");
	            String description = read.nextLine();
	            System.out.print("Ingrese la cantidad del producto: ");
	            int quantity = read.nextInt();
	            Product product = new Product(productId, description, quantity);
	            cart.addProduct(product);
	            System.out.println("Producto agregado al carrito");
	        } else {
	            System.out.println("Carrito no encontrado");
	        }
	        
	        System.out.println("Presione Enter para volver al menú");
            read.nextLine();
	    }

	    //Funcion realizada para borrar un carrito
	    private static void removeCart() {
	        System.out.print("Ingrese el ID del carrito: ");
	        int id = read.nextInt();
	        Cart cart = cartController.getCart(id);//comprobamos que el carrito existe
	        if (cart != null) {
	            cartController.removeCart(cart);// lo quitamos de la lista de carritos
	            System.out.println("Carrito eliminado");
	        } else {
	            System.out.println("Carrito no encontrado");
	        }
	        
	        System.out.println("Presione Enter para volver al menú");
            read.nextLine();
	    }
	}

	

