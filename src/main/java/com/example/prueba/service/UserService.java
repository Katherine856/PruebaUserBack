package com.example.prueba.service;

import com.example.prueba.exceptions.MisswrittenDocNumException;
import com.example.prueba.exceptions.NotFoundDocTypeException;
import com.example.prueba.exceptions.UserNotFoundException;
import com.example.prueba.response.UserResponse;
import com.example.prueba.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	private static final List<String> docTypes = Arrays.asList("C","P");
	
	private static final List<User> users = Arrays.asList(
			new User("C", "23445322", "Juan", "Pablo", "Perez", "Garcia", "123456789", "123 Fake Street", "Bogotá")
			);

    public UserResponse getUserInfo(String documentType, String documentNumber) throws NotFoundDocTypeException, MisswrittenDocNumException, UserNotFoundException, Exception{

    	Optional.ofNullable(documentType)
    			.filter(a -> !a.isBlank() && !a.isEmpty())
    			.orElseThrow(() -> new NotFoundDocTypeException());
    	
    	// Validate document type
    	docTypes.stream()
    			.filter(documentType::equals)
    			.findFirst()
    			.orElseThrow(() -> new NotFoundDocTypeException(documentType));
    			
        // Validate document number
    	Optional.ofNullable(documentNumber)
    			.filter(a -> !a.isBlank() && !a.isEmpty())
    			.orElseThrow(() -> new MisswrittenDocNumException());

    	// Mock data only for specific document number
    	User targetUser = users.stream()
    			.filter(user -> user.getDocumentNumber().equals(documentNumber) 
    						&& user.getDocumentType().equals(documentType))
    			.findFirst()
    			.orElseThrow(() -> new UserNotFoundException(documentNumber));
    		
		UserResponse response = new UserResponse();
		response.setFirstName(targetUser.getFirstName());
		response.setMiddleName(targetUser.getMiddleName());
		response.setLastName(targetUser.getLastName());
		response.setSecondLastName(targetUser.getSecondLastName());
		response.setPhoneNumber(targetUser.getPhoneNumber());
		response.setAddress(targetUser.getAddress());
		response.setCity(targetUser.getCity());
		
		return response;
		  
    }
    
}
