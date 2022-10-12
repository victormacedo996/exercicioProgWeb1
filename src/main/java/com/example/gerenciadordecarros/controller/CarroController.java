package com.example.gerenciadordecarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gerenciadordecarros.domain.Carro;
import com.example.gerenciadordecarros.service.CarroService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("carros")
public class CarroController {

    @Autowired
    private CarroService service;



    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("carros/listar");
        mv.addObject("carros", service.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("carros/cadastrar");
        mv.addObject("carro", new Carro());
       
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(Carro carro) {
        service.save(carro);
        return "redirect:/carros/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/carros/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) throws ObjectNotFoundException {
        ModelAndView mv = new ModelAndView("carros/editar");
        mv.addObject("carro", service.findOne(id));
      
        return mv;
    }

    @PostMapping("/atualizar")
    public String atualizar(Carro carro) throws ObjectNotFoundException {
        service.update(carro);
        return "redirect:/carros/listar";
    }

}
