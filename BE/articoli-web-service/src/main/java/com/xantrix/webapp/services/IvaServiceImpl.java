package com.xantrix.webapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.xantrix.webapp.dtos.IvaDto;
import com.xantrix.webapp.entities.Iva;
import com.xantrix.webapp.repository.IvaRepository;


@Service
@Transactional(readOnly = true)
public class IvaServiceImpl implements IvaService
{
	@Autowired
	IvaRepository ivaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<IvaDto> SelTutti() 
	{
		List<Iva> iva =  ivaRepository.findAll();
		
		List<IvaDto> retVal = iva
		        .stream()
		        .map(source -> modelMapper.map(source, IvaDto.class))
		        .collect(Collectors.toList());
		
		return retVal;
	}

}
