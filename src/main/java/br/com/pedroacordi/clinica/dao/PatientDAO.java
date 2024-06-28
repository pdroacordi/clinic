package br.com.pedroacordi.clinica.dao;

import br.com.pedroacordi.clinica.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDAO extends JpaRepository<Patient, Integer> {

    @Query("SELECT p FROM Patient p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    public List<Patient> findByNameContaining(@Param("keyword") String keyword);

    public Page<Patient> findByOrderByNameAsc(Pageable pageable);
}
