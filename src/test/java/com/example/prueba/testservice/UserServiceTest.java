package com.example.prueba.testservice;

import com.example.prueba.exceptions.MisswrittenDocNumException;
import com.example.prueba.exceptions.NotFoundDocTypeException;
import com.example.prueba.exceptions.UserNotFoundException;
import com.example.prueba.response.UserResponse;
import com.example.prueba.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testGetUserInfo_Success() throws Exception {
        UserResponse response = userService.getUserInfo("C", "23445322");

        assertNotNull(response);
        assertEquals("Juan", response.getFirstName());
        assertEquals("Pablo", response.getMiddleName());
        assertEquals("Perez", response.getLastName());
        assertEquals("Garcia", response.getSecondLastName());
        assertEquals("123456789", response.getPhoneNumber());
        assertEquals("123 Fake Street", response.getAddress());
        assertEquals("Bogotá", response.getCity());
    }

    @Test
    void testGetUserInfo_DocumentTypeNotFound() {
        NotFoundDocTypeException thrown = assertThrows(
            NotFoundDocTypeException.class,
            () -> userService.getUserInfo("InvalidType", "23445322")
        );
        assertEquals("Tipo de documento inválido. Solo se permiten 'C' (Cédula) o 'P' (Pasaporte).", thrown.getMessage());
    }

    @Test
    void testGetUserInfo_MisswrittenDocNumException() {
        MisswrittenDocNumException thrown = assertThrows(
            MisswrittenDocNumException.class,
            () -> userService.getUserInfo("C", "")
        );
        assertEquals("El número de documento no puede estar vacío.", thrown.getMessage());
    }

    @Test
    void testGetUserInfo_UserNotFoundException() {
        UserNotFoundException thrown = assertThrows(
            UserNotFoundException.class,
            () -> userService.getUserInfo("C", "99999999")
        );
        assertEquals("Usuario 99999999 no encontrado.", thrown.getMessage());
    }

    @Test
    void testGetUserInfo_NullDocumentType() {
        NotFoundDocTypeException thrown = assertThrows(
            NotFoundDocTypeException.class,
            () -> userService.getUserInfo(null, "23445322")
        );
        assertEquals("Debe ingresar un tipo de documento. Solo se permiten 'C' (Cédula) o 'P' (Pasaporte).", thrown.getMessage());
    }

    @Test
    void testGetUserInfo_EmptyDocumentNumber() {
        MisswrittenDocNumException thrown = assertThrows(
            MisswrittenDocNumException.class,
            () -> userService.getUserInfo("C", null)
        );
        assertEquals("El número de documento no puede estar vacío.", thrown.getMessage());
    }
}
