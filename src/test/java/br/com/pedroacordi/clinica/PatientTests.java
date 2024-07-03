package br.com.pedroacordi.clinica;

import br.com.pedroacordi.clinica.model.Patient;
import br.com.pedroacordi.clinica.service.patient.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class PatientTests {
    @Autowired
    IPatientService service;
    @Test
    public void shouldDeletePatient(){
        assertTrue( service.delete( 10 ) );
    }

    @Test
    public void shouldNotDeletePatient(){
        assertFalse(service.delete(1000));
    }

    @Test
    public void shouldRetrievePatients(){
        assertTrue(!service.findByName("a").isEmpty());
    }

    @Test
    public void shouldNotRetrievePatients(){
        assertFalse(!service.findByName("adamastor").isEmpty());
    }

}

