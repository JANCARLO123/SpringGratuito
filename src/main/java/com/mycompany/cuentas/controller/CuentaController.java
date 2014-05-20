package com.mycompany.cuentas.controller;

import com.mycompany.cuentas.dao.CuentaDAO;
import com.mycompany.cuentas.modelo.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jaime on 09/05/2014.
 */
@Controller
public class CuentaController {

    @Autowired
    private CuentaDAO cuentaDAO;

    @RequestMapping("/form")
    public String holamundo(){

        return "cuenta/formulario";
    }

    @RequestMapping(value = "/agregarCuenta", method = RequestMethod.POST)
    public String guardarFormulario( @Valid Cuenta cuenta,BindingResult result){
        if (result.hasErrors()) {
            return "cuenta/formulario";
        }

      ;
        cuentaDAO.agregar(cuenta);
        return  "cuenta/cuenta-agregada";
    }

    @RequestMapping("/listarCuentas")
    public String listar(Model mv){

        List<Cuenta> cuentas = cuentaDAO.listar();
        mv.addAttribute("cuentas",cuentas);
        return "cuenta/lista";
    }

    @RequestMapping("/eliminaCuenta")
    public String remove(Cuenta
                                 cuenta) {

        cuentaDAO.eliminar(cuenta);
        return "forward:listarCuentas";
    }

    @RequestMapping("/muestraCuenta")
    public String muestra(Long id,
                          Model model) {

        model.addAttribute("cuenta",
                cuentaDAO.buscarPorId(id));
        return "cuenta/muestra";
    }

    @RequestMapping("/modificarCuenta")
    public String modificar(Cuenta cuenta) {

        cuentaDAO.modificar(cuenta);
        return "redirect:listarCuentas";
    }

    @RequestMapping(value = "/pagarCuenta", method = RequestMethod.POST)
    public void pagar(Long id,HttpServletResponse response) {

        cuentaDAO.pagar(id);
        response.setStatus(200);
    }
}
