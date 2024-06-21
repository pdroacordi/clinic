package br.com.pedroacordi.clinica.controller;

import br.com.pedroacordi.clinica.model.Patient;
import br.com.pedroacordi.clinica.service.patient.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PatientController {
    @Autowired
    private IPatientService service;

    @GetMapping("/patients/search")
    public ResponseEntity<List<Patient>> getByName(@RequestParam(name="name") String name){
        List<Patient> list = service.findByName(name);
        if(list.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) throws Exception{
        Patient p = service.create(patient);
        if( p == null )
            return ResponseEntity.badRequest().build();
        return ResponseEntity.created(new URI("/patients/"+p.getId())).body(p);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Integer id){
        Patient p = service.findById(id);
        if(p == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
        if(patient.getId() == null)
            patient.setId(id);
        Patient p = service.update(patient);
        if(p == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id){
        return service.delete(id)
                ? ResponseEntity.ok("Paciente excluído")
                : ResponseEntity.notFound().build();
    }



}
