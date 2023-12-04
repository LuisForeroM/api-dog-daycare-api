package edu.unisabana.arqSoftware.restAPIdogdaycare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CLIENT")
public class Client  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CLIENT_ID", nullable = false, length=11)
    private Integer clientId;

    @Column(name="NAME_CLIENT")
    private String nameClient;

    @Column(name="DOCUMENT_CLIENT")
    private long documentClient;

    @Column(name="ADDRESS_CLIENT")
    private String addressClient;

    @Column(name="EMAIL_CLIENT")
    private String emailClient;

}
