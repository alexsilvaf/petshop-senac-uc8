package com.senac.starter.controllers;

import com.senac.starter.models.Venda;
import com.senac.starter.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("venda/venda");

        List<Venda> vendas =vendaRepository.findAll();

        modelAndView.addObject("vendas", vendas);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalharVenda(@PathVariable Long id){

        Venda venda = vendaRepository.findVendaById(id);

        ModelAndView modelAndView  = new ModelAndView("venda/venda-detalhe");

        modelAndView.addObject("vendaEntity",venda);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionarVendaPage(){
        ModelAndView modelAndView = new ModelAndView("venda/venda-detalhe");
        modelAndView.addObject("vendaEntity", new Venda());
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarVenda(Venda venda){

        vendaRepository.save(venda);

        return "redirect:/vendas";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarVendaPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("venda/venda-editar");

        Venda venda = vendaRepository.findVendaById(id);
        modelAndView.addObject("vendaEntity",venda);

        return modelAndView;
    }

    @GetMapping("/deletar/{id}")
    public String deleteVendaPage(@PathVariable Long id){

        Venda venda = vendaRepository.findVendaById(id);

        vendaRepository.deleteById(id);

        return "redirect:/vendas";
    }
}
