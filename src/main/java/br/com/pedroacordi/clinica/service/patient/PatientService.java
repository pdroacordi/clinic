package br.com.pedroacordi.clinica.service.patient;

import br.com.pedroacordi.clinica.dao.PatientDAO;
import br.com.pedroacordi.clinica.model.Diagnosis;
import br.com.pedroacordi.clinica.model.Media;
import br.com.pedroacordi.clinica.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PatientService implements IPatientService{

    @Autowired
    private PatientDAO dao;

    private static final int PAGE_SIZE = 2;

    @Override
    public Patient create(Patient patient) {
        if(patient.getDiagnosis() == null ) {
            Diagnosis diagnosis = new Diagnosis();
            patient.setDiagnosis(diagnosis);
        }
        for(Media m : patient.getMedia()){
            m.setPatient(patient);
        }
        patient.getDiagnosis().setUuid(UUID.randomUUID().toString());
        patient.getDiagnosis().setPatient(patient);

        patient.setActive(1);
        return dao.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        Patient tmp = dao.findById(patient.getId()).orElse(null);
        if(tmp == null)
            return null;

        if(patient.getActive() != null)
            tmp.setActive(patient.getActive());
        if(patient.getAddress() != null)
            tmp.setAddress(patient.getAddress());
        if(patient.getBirthday() != null)
            tmp.setBirthday(patient.getBirthday());
        if(patient.getName() != null)
            tmp.setName(patient.getName());
        if(patient.getAddOn() != null)
            tmp.setAddOn(patient.getAddOn());
        if(patient.getCity() != null)
            tmp.setCity(patient.getCity());
        if(patient.getGender() != null)
            tmp.setGender(patient.getGender());
        if(patient.getNum() != null)
            tmp.setNum(patient.getNum());
        if(patient.getOccupation() != null)
            tmp.setOccupation(patient.getOccupation());
        if(patient.getZipCode() != null)
            tmp.setZipCode(patient.getZipCode());
        if(patient.getState() != null)
            tmp.setState(patient.getState());

        if(patient.getDiagnosis().getClinicalDiagnosis() != null)
            tmp.getDiagnosis().setClinicalDiagnosis( patient.getDiagnosis().getClinicalDiagnosis() );
        if(patient.getDiagnosis().getClinicalDonduct() != null)
            tmp.getDiagnosis().setClinicalDonduct( patient.getDiagnosis().getClinicalDonduct() );
        if(patient.getDiagnosis().getHmpHma() != null)
            tmp.getDiagnosis().setHmpHma( patient.getDiagnosis().getHmpHma() );
        if(patient.getDiagnosis().getPictureLink() != null)
            tmp.getDiagnosis().setPictureLink( patient.getDiagnosis().getPictureLink() );
        if(patient.getDiagnosis().getMainComplain() != null)
            tmp.getDiagnosis().setMainComplain( patient.getDiagnosis().getMainComplain() );
        if(patient.getDiagnosis().getComplementaryExams() != null)
            tmp.getDiagnosis().setComplementaryExams( patient.getDiagnosis().getComplementaryExams() );
        if(patient.getDiagnosis().getMedications() != null)
            tmp.getDiagnosis().setMedications( patient.getDiagnosis().getMedications() );

        return dao.save(tmp);
    }

    @Override
    public List<Patient> findByName(String name) {
        return dao.findByNameContaining(name);
    }

    @Override
    public Patient findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        Patient patient = findById(id);
        if(patient == null)
            return false;
        patient.setActive(0);
        dao.save(patient);
        return true;
    }

    @Override
    public Page<Patient> getPatients(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE );
        return dao.findByOrderByNameAsc(pageable);
    }


}
