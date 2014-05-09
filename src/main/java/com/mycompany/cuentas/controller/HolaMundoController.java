package com.mycompany.cuentas.controller;

import com.mycompany.cuentas.dao.CuentaDAO;
import com.mycompany.cuentas.modelo.Cuenta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jaime on 09/05/2014.
 */
@Controller
public class HolaMundoController {
    @RequestMapping("/holaMundoSpring")
         public String initFormulario(){
        System.out.println("Hola Mundo!!!!");
        return  "hola-mundo";
    }



}
