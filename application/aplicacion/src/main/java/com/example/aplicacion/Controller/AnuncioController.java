/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.Controller;

import com.example.aplicacion.Model.Anuncio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author Ariana
 */

@Controller
@RequestMapping("/")
public class AnuncioController {
    private final List<Anuncio>anuncios=new ArrayList<>();
    
    
    @GetMapping
    public String mostrarAnuncios(Model model, HttpSession session) {
        String mensajeBienvenida = (String) session.getAttribute("BIENVENIDA");
        if (mensajeBienvenida == null) {
            mensajeBienvenida = "¡BIENVENIDO AL TABLÓN DE ANUNCIOS!";
            session.setAttribute("BIENVENIDA", mensajeBienvenida);
        } else {
            mensajeBienvenida = null;
        }
        model.addAttribute("anuncios", anuncios);
        model.addAttribute("Bienvenida", mensajeBienvenida);
        return "index";
    }

    @GetMapping("/anuncio/{index}")
    public String verAnuncio(@PathVariable int index, Model model) {
        // Mover el código dentro del método
        Anuncio anuncio = anuncios.get(index);
        model.addAttribute("anuncio", anuncio);
        return "detalle";
    }

    @GetMapping("/nuevo")
    public String nuevoAnuncio(Model model, HttpSession session) {
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");
        model.addAttribute("nombreUsuario", nombreUsuario);
        model.addAttribute("anuncio", new Anuncio());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarAnuncio(@ModelAttribute Anuncio anuncio, HttpSession session, Model model) {
        String nombreUsuario = anuncio.getNombre();
        session.setAttribute("nombreUsuario", nombreUsuario);
        anuncios.add(anuncio);
        model.addAttribute("anuncio", anuncio);
        return "exito";
    }
}


