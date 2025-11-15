package com.ejerciciospring.app.controller;

import com.ejerciciospring.app.model.Club;
import com.ejerciciospring.app.model.Entrenador;
import com.ejerciciospring.app.repository.ClubRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClubController {
	
	 private final ClubRepository clubs;

	    public ClubController(ClubRepository clubs) {
	        this.clubs = clubs;
	    }

	    // Portada
	    @GetMapping("/")
	    public String home(Model model) {
	        Club club = clubs.findAll().stream().findFirst().orElse(null);
	        model.addAttribute("club", club);
	        return "index";
	    }

	    // Form para editar/crear entrenador del club (id fijo del club demo)
	    @GetMapping("/club/editar")
	    public String editar(Model model) {
	        Club club = clubs.findAll().stream().findFirst().orElse(null);
	        if (club == null) return "redirect:/";
	        Entrenador entrenador = club.getEntrenador();
	        if (entrenador == null) entrenador = new Entrenador();
	        model.addAttribute("club", club);
	        model.addAttribute("entrenador", entrenador);
	        return "club_editar";
	    }

	    @PostMapping("/club/guardar")
	    public String guardar(@ModelAttribute("club") Club clubForm,
	                          @Valid @ModelAttribute("entrenador") Entrenador entrenador,
	                          BindingResult br,
	                          Model model) {
	        Club club = clubs.findAll().stream().findFirst().orElse(null);
	        if (club == null) return "redirect:/";

	        if (br.hasErrors()) {
	            model.addAttribute("club", club);
	            return "club_editar";
	        }

	        // Asignar entrenador al club y guardar (cascade ALL lo persiste)
	        club.setEntrenador(entrenador);
	        club.setNombre(clubForm.getNombre());
	        club.setCiudad(clubForm.getCiudad());
	        club.setEstadio(clubForm.getEstadio());
	        club.setFundacion(clubForm.getFundacion());
	        clubs.save(club);

	        return "redirect:/";
	    }
        

}
