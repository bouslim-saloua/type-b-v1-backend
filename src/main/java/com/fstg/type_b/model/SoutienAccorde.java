/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
@Entity
public class SoutienAccorde implements Serializable{
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private BigDecimal montant;

@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "demande_id", nullable = true)
@JsonBackReference
private Demande demande;
}
