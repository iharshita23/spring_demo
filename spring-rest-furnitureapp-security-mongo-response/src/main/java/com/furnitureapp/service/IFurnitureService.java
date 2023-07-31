package com.furnitureapp.service;
import java.util.List;
import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.model.FurnitureDTO;

public interface IFurnitureService {
	
	void addFurniture(FurnitureDTO furnitureDTO);
	FurnitureDTO updateFurniture(FurnitureDTO furnitureDTO);
	void deleteFurniture(Integer seater);
	FurnitureDTO getBySeater(Integer seater) throws FurnitureNotFoundException;
	
	List<FurnitureDTO> getAll();
	List<FurnitureDTO> getByName(String name) throws FurnitureNotFoundException;
	List<FurnitureDTO> getByPrice(double price) throws FurnitureNotFoundException;
	List<FurnitureDTO> getByUpholstery(String upholstery) throws FurnitureNotFoundException;
	List<FurnitureDTO> getByColour(String colour) throws FurnitureNotFoundException;
	
}
