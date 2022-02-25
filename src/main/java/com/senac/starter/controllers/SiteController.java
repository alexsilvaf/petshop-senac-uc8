package com.senac.starter.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.senac.starter.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/")
public class SiteController {

    @GetMapping()
    public ModelAndView dashBoard(){

        return new ModelAndView("dashboard");
    }

    @GetMapping("/aviso")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        Usuario usuario = new Usuario();

        LocalDateTime now = LocalDateTime.now();
        String mensagem = "Hello word";


        modelAndView.addObject("mensagem",mensagem);
        return modelAndView;
    }









    @GetMapping("/filmes")
    public String filmes(){
        System.out.println("entrou no filmes");

        return "filmes";
    }
    @GetMapping("/jogos")
    public String jogos(){
        System.out.println("entrou no jogos");
        return "jogos";
    }
    @GetMapping("/posts")
    public String posts(){
        System.out.println("entrou no posts");

        return "posts";
    }

    @GetMapping("/contato")
    public String contato(){
        System.out.println("entrou no contato");
        return "contato";
    }
}
