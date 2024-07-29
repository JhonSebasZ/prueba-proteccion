package com.prueba_proteccion.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import com.prueba_proteccion.Entity.FibonacciSerie;
import com.prueba_proteccion.Reposirory.FibonacciSerieRepository;

@Service
public class FibonacciSerieServiceImp implements FibonacciSerieService{
	
	@Autowired
	FibonacciSerieRepository fiboRepo;

	@Override
	public List<Integer> saveFibonacciSeries(int seed1, int seed2, int n) {
		List<Integer> fibonacciSeries = new ArrayList<>();
        fibonacciSeries.add(seed1);
        fibonacciSeries.add(seed2);

        for (int i = 2; i < n + 2; i++) {
            int nextNumber = fibonacciSeries.get(i - 1) + fibonacciSeries.get(i - 2);
            fibonacciSeries.add(nextNumber);
        }

        Collections.reverse(fibonacciSeries);

        FibonacciSerie series = new FibonacciSerie();
        series.setSeed1(seed1);
        series.setSeed2(seed2);
        series.setCount(n);
        series.setNumbers(fibonacciSeries.stream().map(String::valueOf).collect(Collectors.joining(",")));
        series.setCreatedAt(LocalDateTime.now());

        fiboRepo.save(series);

        return fibonacciSeries;
	}

	@Override
	public List<FibonacciSerie> getAllFibonacciSeries() {
		return fiboRepo.findAll();
	}
	
	public List<Integer> convertStringToList(String numbers) {
        return Stream.of(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

	@Override
	public void sendEmail(String to, String subject, String text) {
		/*
		 * SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        MailSender.send(message);*/
		
	}
	
}
