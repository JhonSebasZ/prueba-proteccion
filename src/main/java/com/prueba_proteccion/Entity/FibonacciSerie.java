package com.prueba_proteccion.Entity;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="fibonacciserie")
public class FibonacciSerie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seed1;
    private int seed2;
    private int count;

    @Column(length = 1000, name = "number")
    private String numbers;

    private LocalDateTime createdAt;
    
    public void setSeed1(int seed1) {
    	this.seed1=seed1;
    }
    
    public void setSeed2(int seed2) {
    	this.seed2=seed2;
    }
    
    public void setCount(int n) {
    	this.count=n;
    }
    
    public void setNumbers(String numbers) {
    	this.numbers=numbers;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
    	this.createdAt=createdAt;
    }
}
