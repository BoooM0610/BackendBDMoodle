package com.example.backendbdmoodle.controllers;

import com.example.backendbdmoodle.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController
{
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping(value = {"/index", "", "/", "/home"})
    public String index(Model model)
    {
        model.addAttribute("titulo", textoIndex);
        return "index.html";
    }

    @GetMapping(value = "/perfil")
    public String perfil(Model model)
    {
        Usuario usuario = new Usuario();
        usuario.setNombre("Pepe");
        usuario.setApellido("Flores");
        usuario.setEmail("pepe@correo.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil.html";
    }

    @GetMapping(value = "/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", textoListar);
        model.addAttribute("usuarios", pasarUsuarios());

        return "listar.html";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> pasarUsuarios()
    {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Andres", "guzman", "correo@gmail.com"));
        usuarios.add(new Usuario("pepe", "fle", "corrdwdweo@gmail.com"));
        usuarios.add(new Usuario("maria", "deee", "wdw@gmail.com"));
        usuarios.add(new Usuario("pablo", "perez", "pablo@gmail.com"));

        return usuarios;
    }
}
