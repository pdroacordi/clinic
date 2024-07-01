package br.com.pedroacordi.clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="PACIENTE")
public class Patient {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NOME", length = 100)
    private String name;

    @Column(name="DATA_NASC")
    private Date birthday;

    @Column(name="SEXO", length = 1)
    private String gender;

    @Column(name="TELEFONE", length = 13)
    private String phoneNumber;

    @Column(name="CEP", length = 8)
    private String zipCode;

    @Column(name="ENDERECO", length = 100)
    private String address;

    @Column(name="BAIRRO", length = 50)
    private String neighborhood;


    @Column(name="COMPLEMENTO", length=30)
    private String addOn;

    @Column(name="NUMERO", length=10)
    private String num;

    @Column(name="CIDADE", length=60)
    private String city;

    @Column(name="ESTADO", length=2)
    private String state;

    @Column(name="OCUPACAO", length=45)
    private String occupation;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("patient")
    private Diagnosis diagnosis;

    @Column(name="ATIVO")
    private Integer active;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("patient")
    private List<Media> media;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
