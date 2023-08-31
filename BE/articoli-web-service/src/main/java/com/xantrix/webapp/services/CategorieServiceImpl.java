package com.xantrix.webapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xantrix.webapp.dtos.CategoriaDto;
import com.xantrix.webapp.entities.FamAssort;
import com.xantrix.webapp.repository.CategoriaRepository;


@Service
@Transactional(readOnly = true)
public class CategorieServiceImpl implements CategorieService
{
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<CategoriaDto> SelTutti() 
	{
		List<FamAssort> categorie =  categoriaRepository.findAll();
		
		List<CategoriaDto> retVal = categorie
		        .stream()
		        .map(source -> modelMapper.map(source, CategoriaDto.class))
		        .collect(Collectors.toList());
		
		return retVal;
	}

}
