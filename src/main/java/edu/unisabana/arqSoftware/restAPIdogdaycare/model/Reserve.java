package edu.unisabana.arqSoftware.restAPIdogdaycare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="RESERVE")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RESERVE_ID", nullable = false,length = 11)
    private Integer reserveId;

    @ManyToOne
    @JoinColumn(name="PET_ID", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name="CLIENT_ID",nullable = false)
    private Client client;

    @Column(name="RESERVE_DATE",nullable = false,length = 11)
    private String reserveDate;




}
