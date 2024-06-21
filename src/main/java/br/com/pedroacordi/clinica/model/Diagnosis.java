package br.com.pedroacordi.clinica.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="DIAGNOSTICO")
public class Diagnosis {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name="DIAGNOSTICO_CLINICO", columnDefinition = "TEXT")
    private String clinicalDiagnosis;

    @Column(name="QUEIXA_PRINCIPAL", columnDefinition = "TEXT")
    private String mainComplain;

    @Column(name="HMP_HMA", columnDefinition = "TEXT")
    private String hmpHma;

    @Column(name="MEDICACOES", columnDefinition = "TEXT")
    private String medications;

    @Column(name="EXAMES_COMPLEMENTARES", columnDefinition = "TEXT")
    private String complementaryExams;

    @Column(name="CONDUTA_CLINICA", columnDefinition = "TEXT")
    private String clinicalDonduct;

    @Column(name="LINK_FOTO", length = 255)
    private String pictureLink;

    @Column(name="UUID", length = 45, unique = true)
    private String uuid;

    @OneToOne
    @JoinColumn(name = "PACIENTE_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties("diagnosis")
    private Patient patient;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public String getMainComplain() {
        return mainComplain;
    }

    public void setMainComplain(String mainComplain) {
        this.mainComplain = mainComplain;
    }

    public String getHmpHma() {
        return hmpHma;
    }

    public void setHmpHma(String hmpHma) {
        this.hmpHma = hmpHma;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getComplementaryExams() {
        return complementaryExams;
    }

    public void setComplementaryExams(String complementaryExams) {
        this.complementaryExams = complementaryExams;
    }

    public String getClinicalDonduct() {
        return clinicalDonduct;
    }

    public void setClinicalDonduct(String clinicalDonduct) {
        this.clinicalDonduct = clinicalDonduct;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
