package net.asutosh.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wikimidiaData_Store" )
@Getter
@Setter
public class WikimidiaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Column( length = 5000)
    private String wikimidiaEventData;

}
