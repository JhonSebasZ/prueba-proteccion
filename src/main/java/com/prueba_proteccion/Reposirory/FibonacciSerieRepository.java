package com.prueba_proteccion.Reposirory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba_proteccion.Entity.FibonacciSerie;

public interface FibonacciSerieRepository extends JpaRepository<FibonacciSerie, Integer>{

}
