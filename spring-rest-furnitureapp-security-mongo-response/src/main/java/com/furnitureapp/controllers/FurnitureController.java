package com.furnitureapp.controllers;

import java.time.LocalDateTime;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.model.FurnitureDTO;
import com.furnitureapp.service.IFurnitureService;

@RestController
@RequestMapping("/furniture-api")
public class FurnitureController {
	
	@Autowired
	IFurnitureService ifurnitureservice;
	
//	public FurnitureController(IFurnitureService ifurnitureservice) {
//		super();
//		this.ifurnitureservice = ifurnitureservice;
//	}
	
	@PostMapping("/furniture")
    ResponseEntity<Void> addFurniture(@RequestBody FurnitureDTO furnitureDTO) throws FurnitureNotFoundException{
        ifurnitureservice.addFurniture(furnitureDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	@PutMapping("/furniture")
    ResponseEntity<FurnitureDTO> updateFurniture(@RequestBody FurnitureDTO furnitureDTO) throws FurnitureNotFoundException{
    	FurnitureDTO furnituredtos = ifurnitureservice.updateFurniture(furnitureDTO);
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.add("desc", "Updating furniture details");
    	 return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(furnituredtos);
    }
	
	@DeleteMapping("/furniture/{seater}")
    ResponseEntity<Void> deleteFurniture(@PathVariable("seater")Integer seater) throws FurnitureNotFoundException{
    	ifurnitureservice.deleteFurniture(seater);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
	
	@GetMapping("/furniture")
    ResponseEntity <List<FurnitureDTO>> getAll() {
        List<FurnitureDTO> furnituredtos = ifurnitureservice.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the list of furniture");
        headers.add("time retreived", LocalDateTime.now().toString());
        ResponseEntity<List<FurnitureDTO>> responseEntity = new ResponseEntity<List<FurnitureDTO>>(furnituredtos,headers,HttpStatus.OK);
        return responseEntity;       
    }
	
	@GetMapping("/furniture/{seater}")
    ResponseEntity<FurnitureDTO> getBySeater(@PathVariable Integer seater) throws FurnitureNotFoundException{
        FurnitureDTO furnituredto = ifurnitureservice.getBySeater(seater);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the furniture by seater");
        headers.add("time retreived", LocalDateTime.now().toString());
        ResponseEntity<FurnitureDTO> responseEntity = new ResponseEntity<>(furnituredto,headers,HttpStatus.OK);
        return responseEntity;       
    }
	
	@GetMapping("/furniture/name/{name}")
    ResponseEntity <List<FurnitureDTO>> getByName(@PathVariable("name") String name)throws FurnitureNotFoundException{
        List<FurnitureDTO> furnituredtos = ifurnitureservice.getByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the name of furniture");
        return ResponseEntity.ok().headers(headers).body(furnituredtos);
    }
    
    @GetMapping("/furniture/upholstery/{upholstery}")
        ResponseEntity <List<FurnitureDTO>> getByUpholstery(@PathVariable("upholstery") String upholstery) throws FurnitureNotFoundException {
            List<FurnitureDTO> furnituredtos = ifurnitureservice.getByUpholstery(upholstery);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc", "Getting the list upholstery");
            return ResponseEntity.ok().headers(headers).body(furnituredtos);
    }
    
    @GetMapping("/furniture/price/{price}")
        ResponseEntity <List<FurnitureDTO>> getByPrice(@PathVariable("price") double price) throws FurnitureNotFoundException {
            List<FurnitureDTO> furnituredtos =  ifurnitureservice.getByPrice(price);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc", "Getting the list of furniture by price");
            return ResponseEntity.ok().headers(headers).body(furnituredtos);
     }
    
    @GetMapping("/furniture/colour/{colour}")
    ResponseEntity <List<FurnitureDTO>> getByColour(@PathVariable("colour") String colour) throws FurnitureNotFoundException {
        List<FurnitureDTO> furnituredtos =  ifurnitureservice.getByColour(colour);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the list of furniture by colour");
        return ResponseEntity.ok().headers(headers).body(furnituredtos);
    }
    
	
}
