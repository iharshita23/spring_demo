package com.furnitureapp.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.furnitureapp.model.Furniture;

@Repository
public interface IFurnitureRepository extends MongoRepository<Furniture, Integer>{

	List<Furniture> getByName(String name);
	List<Furniture> getByPrice(double price);
	List<Furniture> getByUpholstery(String upholstery);
	List<Furniture> getByColour(String colour);
}
