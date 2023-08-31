package com.xantrix.webapp.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;
 

public interface ArticoliService 
{
	public Iterable<Articoli> SelTutti();
	
	public List<ArticoliDto> SelByDescrizione(String descrizione);
		
	public List<Articoli> SelByDescrizione(String descrizione, Pageable pageable);
	
	public ArticoliDto SelByCodArt(String codArt);
	
	public Articoli SelByCodArt2(String codArt);
	
	public ArticoliDto SelByBarcode(String barcode);
	
	public void DelArticolo(Articoli articolo);
	
	public void InsArticolo(Articoli articolo);
}