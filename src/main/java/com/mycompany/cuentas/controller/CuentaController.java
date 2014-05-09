package com.mycompany.cuentas.controller;

import com.mycompany.cuentas.dao.CuentaDAO;
import com.mycompany.cuentas.modelo.Cuenta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Jaime on 09/05/2014.
 */
@Controller
public class CuentaController {
        @RequestMapping("/form")
        public String holamundo(){

            return "cuenta/formulario";
        }

    @RequestMapping("/agregarCuenta")
    public String guardarFormulario( Cuenta cuenta){
        System.out.println("La cuenta agregada es : " + cuenta.getDescripcion());
        CuentaDAO cuentaDAO = new CuentaDAO();
        cuentaDAO.agregar(cuenta);
        return  "cuenta/cuenta-agregada";
    }

    @RequestMapping("/listarCuentas")
    public String listar(Model mv){
        CuentaDAO dao = new CuentaDAO();
        List<Cuenta> cuentas = dao.listar();
        mv.addAttribute("cuentas",cuentas);
        return "cuenta/lista";
    }

    @RequestMapping("/eliminaCuenta")
    public String remove(Cuenta
                                 cuenta) {
        CuentaDAO dao = new
                CuentaDAO();
        dao.eliminar(cuenta);
        return "forward:listarCuentas";
    }

    @RequestMapping("/muestraCuenta")
    public String muestra(Long id,
                          Model model) {
        CuentaDAO dao = new
                CuentaDAO();
        model.addAttribute("cuenta",
                dao.buscarPorId(id));
        return "cuenta/muestra";
    }

    @RequestMapping("/modificarCuenta")
    public String modificar(Cuenta
                                    cuenta) {
        CuentaDAO dao = new CuentaDAO();
        dao.modificar(cuenta);
        return "redirect:listarCuentas";
    }
}
