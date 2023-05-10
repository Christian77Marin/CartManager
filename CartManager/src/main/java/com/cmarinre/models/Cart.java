package com.cmarinre.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cart {
    private int id;
    private List<Product> products;
    private ScheduledExecutorService executor; 
    
    public Cart(int id) {
        this.id = id;
        this.products = new ArrayList<Product>();
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public List<Product> getProducts() {
        return products;
    }
    
    //Esta funcion imprime todos los productos en el carro y los devuelve como string
    public String getProperties() {
    	
    	 StringBuilder builder = new StringBuilder();
    	    builder.append("Productos en el carrito:\n");
    	    for (Product product : products) {
    	        builder.append("ID: ").append(product.getId())
    	               .append(", Nombre: ").append(product.getDescription())
    	               .append(", Cantidad: ").append(product.getQuantity())
    	               .append("\n");
    	    }
    	    return builder.toString();
    	
    }
    
    //Comprobamos si un producto existe dentro del carro
    public Boolean productExist(int id) {
    	for (Product product : products) {
    		if(product.getId() == id) {
    			System.out.print("El Producto con ID: " + product.getId() + " ya existe. \n");
    			return true;
    		}
    	}
    	return false;
    }
    
    //Comprobamos y devolvemos un producto si existe
    public Product product(int id) {
    	for (Product product : products) {
    		if(product.getId() == id) {
    			
    			return product;
    		}
    	}
    	return null;
    }
    //Añadimos un producto al carro 
    public void addProduct(Product product) {
        products.add(product);
       
    }
    //Borramos un producto del carro
    public void removeProduct(Product product) {
        products.remove(product);
        
    }
    //Borramos todos los productos
    public void removeAllProducts() {
        products.clear();
        
    }
    


    //Hilo para determinar si el carro lleva mas de 10 minutos inactivo
    public void startTimeoutThread() {
        executor.schedule(() -> {
            // Si el carrito está vacío, no hace nada
            if (products.isEmpty()) {
                return;
            }
            
            // Si hay productos en el carrito, lo borra y cancela el hilo
            products.clear();
            System.out.println(" \n Carrito:" + this.id +  " borrado por inactividad.");
            executor.shutdown();
        }, 10, TimeUnit.MINUTES);
    }
    //Funcion para borrar el hilo y crear uno nuevo, esta funcion se llama para resetear el tiempo de inactividad
    public void resetTimeoutThread() {
        executor.shutdown();
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }
    
}
