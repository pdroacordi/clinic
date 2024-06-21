package br.com.pedroacordi.clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="Midia")
public class Media {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="DESCRICAO", length=255)
    private String name;

    @Column(name="LINK_MIDIA", length = 255)
    private String link;

    @ManyToOne
    @JoinColumn(name="PACIENTE_ID")
    @JsonIgnoreProperties("media")
    private Patient patient;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
