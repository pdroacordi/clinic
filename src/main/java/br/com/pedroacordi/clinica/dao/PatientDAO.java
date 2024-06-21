package br.com.pedroacordi.clinica.dao;

import br.com.pedroacordi.clinica.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientDAO extends CrudRepository<Patient, Integer> {

    public List<Patient> findByNameContaining(String keyword);

}
