package br.com.pedroacordi.clinica.service.patient;

import br.com.pedroacordi.clinica.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService {

    public Patient create(Patient patient);
    public Patient update(Patient patient);
    public List<Patient> findByName(String name);
    public Patient findById(Integer id);

    public boolean delete(Integer id);

    public Page<Patient> getPatients(int page);

}
