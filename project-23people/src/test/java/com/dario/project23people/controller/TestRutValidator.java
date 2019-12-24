package com.dario.project23people.controller;


import com.dario.project23people.validator.RutValidator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRutValidator {

    private static RutValidator rutValidator = new RutValidator();
    @Test
    public void testValidRut() {
        assertTrue(RutValidator.validateRut("12-4"));
    }

    @Test
    public void testNotValidRut() {
        assertFalse(RutValidator.validateRut("12-2"));
    }

    @Test
    public void testValidRutWithK() {
        assertTrue(RutValidator.validateRut("6-K"));
    }

    @Test
    public void testNotValidRutWithK() {
        assertFalse(RutValidator.validateRut("7-K"));
    }
    @Test
    public void testValidRutWitPointsAndDash() {
        assertTrue(RutValidator.validateRut("18.123.012-6"));
    }


}
