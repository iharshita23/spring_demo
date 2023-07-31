package com.furnitureapp.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class FurnitureMapper {
	
	public Furniture convertToDocument(FurnitureDTO furnitureDTO) {
		Furniture furniture = new Furniture();
		furniture.setName(furnitureDTO.getName());
		furniture.setPrice(furnitureDTO.getPrice());
		furniture.setUpholstery(furnitureDTO.getUpholstery());
		furniture.setSeater(furnitureDTO.getSeater());
		furniture.setColour(furnitureDTO.getColour());
		return furniture;
	}
	
	public FurnitureDTO convertToDTO(Furniture furniture) {
		FurnitureDTO furnitureDTO = new FurnitureDTO();
		furnitureDTO.setName(furniture.getName());
		furnitureDTO.setPrice(furniture.getPrice());
		furnitureDTO.setUpholstery(furniture.getUpholstery());
		furnitureDTO.setSeater(furniture.getSeater());
		furnitureDTO.setColour(furniture.getColour());
		return furnitureDTO;
	}


	
	
	
}
