package com.cmarinre.inicio;

import com.cmarinre.controllers.MenuController;

public class Main {
    public static void main(String[] arg) {

       //Instanciamos el controlador
    	MenuController start = new MenuController();
    	//Llamamos al manejador de menu
    	start.SwitchManager();
    }

}
