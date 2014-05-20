package com.mycompany.cuentas.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompany.cuentas.dao.UsuarioDAO;
import com.mycompany.cuentas.modelo.Usuario;

import javax.servlet.http.HttpSession;

/**
 * Created by Jaime on 20/05/2014.
 */

@Controller
public class UsuarioController {
    @RequestMapping("/loginForm")
    public String formulario(){
        return "usuario/login";
    }

    @RequestMapping("/efectuaLogin")
    public String efectuaLogin(Usuario
                                       usuario, HttpSession session){
        UsuarioDAO usuarioDAO = new
                UsuarioDAO();
        if(usuarioDAO.existeUsuario(usuario
        )){session.setAttribute("usuarioLogueado", usuario);
            return "usuario/menu";
        }
        return "redirect:loginForm";
    }

    @RequestMapping("/logout")
    public String
    formulario(HttpSession session){
        session.invalidate();
        return "redirect:loginForm";
    }
}