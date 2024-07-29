package com.prueba_proteccion.Service;

import java.util.List;

import com.prueba_proteccion.Entity.FibonacciSerie;

public interface FibonacciSerieService {
	
	public List<Integer> saveFibonacciSeries(int seed1, int seed2, int n);
	public List<FibonacciSerie> getAllFibonacciSeries();
	public void sendEmail(String to, String subject, String text);
}
