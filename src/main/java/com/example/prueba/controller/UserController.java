package com.example.prueba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.exceptions.MisswrittenDocNumException;
import com.example.prueba.exceptions.NotFoundDocTypeException;
import com.example.prueba.exceptions.UserNotFoundException;
import com.example.prueba.response.ErrorResponse;
import com.example.prueba.response.UserResponse;
import com.example.prueba.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@GetMapping("/userInfo")
	public ResponseEntity<?> getUserInfo(@RequestParam String documentType, @RequestParam String documentNumber) {
		logger.info("Recibida solicitud con documentType: {} y documentNumber: {}", documentType, documentNumber);
		try {
			UserResponse response = userService.getUserInfo(documentType, documentNumber);
			logger.info("La información del documento es: {} {}", documentNumber, response);
			return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		} catch (NotFoundDocTypeException | MisswrittenDocNumException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (UserNotFoundException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("No se pudo procesar la solicitud"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
