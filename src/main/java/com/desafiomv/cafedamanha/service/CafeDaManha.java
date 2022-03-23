package com.desafiomv.cafedamanha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiomv.cafedamanha.repository.ColaboradorRepository;
import com.desafiomv.cafedamanha.repository.OpcaoRepository;

@Service
public class CafeDaManha {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private OpcaoRepository opcaoRepository;
	

}
