package edu.unisabana.arqSoftware.restAPIdogdaycare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PET_ID", nullable = false,length = 11)
    private Integer petId;

    @Column(name="PET_NAME")
    private String petName;

    @ManyToOne
    @JoinColumn(name="CLIENT_ID", nullable = false)
    private Client client;

}
