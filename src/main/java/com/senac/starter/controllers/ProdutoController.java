package com.senac.starter.controllers;

import com.senac.starter.models.Produto;
import com.senac.starter.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("produto/produto");

        List<Produto> produtos =produtoRepository.findAll();

        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalharProduto(@PathVariable Long id){

        Produto produto = produtoRepository.findProdutoById(id);

        ModelAndView modelAndView  = new ModelAndView("produto/produto-detalhe");

        modelAndView.addObject("produtoEntity",produto);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionarProdutoPage(){
        ModelAndView modelAndView = new ModelAndView("produto/produto-detalhe");
        modelAndView.addObject("produtoEntity", new Produto());
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarProduto(Produto produto){

        produtoRepository.save(produto);

        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarProdutoPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("produto/produto-editar");

        Produto produto = produtoRepository.findProdutoById(id);
        modelAndView.addObject("produtoEntity",produto);

        return modelAndView;
    }

    @GetMapping("/deletar/{id}")
    public String deleteProdutoPage(@PathVariable Long id){

        Produto produto = produtoRepository.findProdutoById(id);

        produtoRepository.deleteById(id);

        return "redirect:/produtos";
    }
}
