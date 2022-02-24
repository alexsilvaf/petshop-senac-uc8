package com.senac.starter.controllers;

import com.senac.starter.models.Usuario;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("usuario/usuario");

        List<Usuario> usuarios =usuarioRepository.findAll();

        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharUsuario(@PathVariable Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);

        ModelAndView modelAndView  = new ModelAndView("usuario/usuario-detalhe");

        modelAndView.addObject("usuarioEntity",usuario);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionarUsuarioPage(){
        ModelAndView modelAndView = new ModelAndView("usuario/usuario-detalhe");
        modelAndView.addObject("usuarioEntity", new Usuario());
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarUsuario(Usuario usuario){

        usuarioRepository.save(usuario);
        Usuario us = new Usuario();

        return "redirect:/usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deleteUsuarioPage(@PathVariable Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);

        usuarioRepository.deleteById(id);

        return "redirect:/usuarios";
    }
}
