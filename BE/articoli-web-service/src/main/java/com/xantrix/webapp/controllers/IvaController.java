package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.dtos.IvaDto;
import com.xantrix.webapp.exceptions.NotFoundException;
import com.xantrix.webapp.services.IvaService;

import lombok.extern.java.Log;

@RestController
@RequestMapping("api/iva")
@Log
@CrossOrigin("http://localhost:4200")
public class IvaController 
{
	@Autowired
	private IvaService ivaService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<IvaDto>> GetIva()
			throws NotFoundException	
	{
		log.info("****** Otteniamo le aliquote IVA  *******");
		
		List<IvaDto> iva = ivaService.SelTutti();
		
		if (iva.isEmpty())
		{
			String ErrMsg = String.format("Nessun elemento esistente!");
			
			log.warning(ErrMsg);
			
			throw new NotFoundException(ErrMsg);
			 
		}
		 
		return new ResponseEntity<List<IvaDto>>(iva, HttpStatus.OK);
		
	}
}
