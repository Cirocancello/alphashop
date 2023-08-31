package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.dtos.CategoriaDto;
import com.xantrix.webapp.exceptions.NotFoundException;
import com.xantrix.webapp.services.CategorieService;

import lombok.extern.java.Log;

@RestController
@RequestMapping("api/cat")
@Log
@CrossOrigin("http://localhost:4200")
public class CategorieController 
{
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<CategoriaDto>> GetCat()
			throws NotFoundException	
	{
		log.info("****** Otteniamo le Categorie  *******");
		
		List<CategoriaDto> categorie = categorieService.SelTutti();
		
		if (categorie.isEmpty())
		{
			String ErrMsg = String.format("Nessun elemento esistente!");
			
			log.warning(ErrMsg);
			
			throw new NotFoundException(ErrMsg);
			 
		}
		 
		return new ResponseEntity<List<CategoriaDto>>(categorie, HttpStatus.OK);
		
	}
	
}
