package com.furnitureapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.FurnitureDTO;
import com.furnitureapp.model.FurnitureMapper;
import com.furnitureapp.repository.IFurnitureRepository;

@Service
public class FurnitureServiceImpl implements IFurnitureService {

	@Autowired
	private IFurnitureRepository ifurnitureRepository;

//	public FurnitureServiceImpl(IFurnitureRepository ifurnitureRepository) {
//		super();
//		this.ifurnitureRepository = ifurnitureRepository;
//	}

	@Autowired
	private FurnitureMapper furnitureMapper;

	@Override
	public void addFurniture(FurnitureDTO furnitureDTO) {
		Furniture furniture = furnitureMapper.convertToDocument(furnitureDTO);
		ifurnitureRepository.insert(furniture);

	}

	@Override
	public FurnitureDTO updateFurniture(FurnitureDTO furnitureDTO) { 
		Furniture furniture = furnitureMapper.convertToDocument(furnitureDTO);
		Furniture nfurniture = ifurnitureRepository.save(furniture);
		return furnitureMapper.convertToDTO(nfurniture);
	}

	@Override
	public void deleteFurniture(Integer seater) {
		ifurnitureRepository.deleteById(seater);

	}

	@Override
	public FurnitureDTO getBySeater(Integer seater) throws FurnitureNotFoundException {
		Furniture furniture = ifurnitureRepository.findById(seater).orElseThrow(() -> new FurnitureNotFoundException("Furniture not found"));
		return furnitureMapper.convertToDTO(furniture);
	}

	@Override
	public List<FurnitureDTO> getAll() {
		List<Furniture> furnitures = ifurnitureRepository.findAll();
		List<FurnitureDTO> furnitureDtos = furnitures.stream().map(furniture -> furnitureMapper.convertToDTO(furniture))
				.toList();
		return furnitureDtos;
	}

	@Override
	public List<FurnitureDTO> getByName(String name) throws FurnitureNotFoundException {
		List<Furniture> furnitures = ifurnitureRepository.getByName(name);
		if (furnitures.isEmpty())
			throw new FurnitureNotFoundException("Furniture not found");
		List<FurnitureDTO> furnitureDtos = furnitures.stream().map(furniture -> furnitureMapper.convertToDTO(furniture))
				.toList();
		return furnitureDtos;

	}

	@Override
	public List<FurnitureDTO> getByPrice(double price) throws FurnitureNotFoundException {
		List<Furniture> furnitures = ifurnitureRepository.getByPrice(price);
		if (furnitures.isEmpty())
			throw new FurnitureNotFoundException("Price not available");
		List<FurnitureDTO> furnitureDtos = furnitures.stream().map(furniture -> furnitureMapper.convertToDTO(furniture))
				.toList();
		return furnitureDtos;
	}

	@Override
	public List<FurnitureDTO> getByUpholstery(String upholstery) throws FurnitureNotFoundException {
		List<Furniture> furnitures = ifurnitureRepository.getByUpholstery(upholstery);
		if (furnitures.isEmpty())
			throw new FurnitureNotFoundException("Upholstery not available");
		List<FurnitureDTO> furnitureDtos = furnitures.stream().map(furniture -> furnitureMapper.convertToDTO(furniture))
				.toList();
		return furnitureDtos;
	}

	@Override
	public List<FurnitureDTO> getByColour(String colour) throws FurnitureNotFoundException {
		List<Furniture> furnitures = ifurnitureRepository.getByColour(colour);
		if (furnitures.isEmpty())
			throw new FurnitureNotFoundException("Colour not found");
		List<FurnitureDTO> furnitureDtos = furnitures.stream().map(furniture -> furnitureMapper.convertToDTO(furniture))
				.toList();
		return furnitureDtos;
	}

}
