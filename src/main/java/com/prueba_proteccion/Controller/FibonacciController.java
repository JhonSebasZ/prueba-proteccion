package com.prueba_proteccion.Controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba_proteccion.Entity.FibonacciSerie;
import com.prueba_proteccion.Service.FibonacciSerieServiceImp;

@Controller
@RequestMapping("/fibonacci")
public class FibonacciController {

	@Autowired
	private FibonacciSerieServiceImp fiboImpl;
	
    @GetMapping("/save")
    public String getFibonacciSeries() {
        LocalTime currentTime = LocalTime.now();
        
        // obtener el último dígito de los minutos
        int seed1 = currentTime.getMinute() % 10; 
        
        // obtener el último dígito de los segundos
        int seed2 = currentTime.getSecond() % 10; 
        
        // cantidad de números a generar
        int count = currentTime.getSecond();     
        fiboImpl.saveFibonacciSeries(seed1, seed2, count);
        
        return "redirect:/fibonacci";
    }

    @GetMapping("")
    public String getAllFibonacciSeries(Model model) {
    	var serie = fiboImpl.getAllFibonacciSeries();
    	model.addAttribute("series", serie);
		return "index";
    }
}
