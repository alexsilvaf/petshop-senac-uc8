package com.senac.starter.controllers;

import com.senac.starter.models.Animal;
import com.senac.starter.repositorys.AnimalRepository;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("animal/animal");

        List<Animal> animais =animalRepository.findAll();

        modelAndView.addObject("animais", animais);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalharAnimal(@PathVariable Long id){

        Animal animal = animalRepository.findAnimalById(id);

        ModelAndView modelAndView  = new ModelAndView("animal/animal-detalhe");

        modelAndView.addObject("animalEntity",animal);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionarAnimalPage(){
        ModelAndView modelAndView = new ModelAndView("animal/animal-detalhe");

        modelAndView.addObject("animalEntity", new Animal());
        modelAndView.addObject("donos", usuarioRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarAnimal(Animal animal){

        animalRepository.save(animal);

        return "redirect:/animais";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarAnimalPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("animal/animal-editar");

        Animal animal = animalRepository.findAnimalById(id);

        modelAndView.addObject("animalEntity",animal);
        modelAndView.addObject("donos", usuarioRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/deletar/{id}")
    public String deleteAnimalPage(@PathVariable Long id){

        Animal animal = animalRepository.findAnimalById(id);

        animalRepository.deleteById(id);

        return "redirect:/animais";
    }
}
