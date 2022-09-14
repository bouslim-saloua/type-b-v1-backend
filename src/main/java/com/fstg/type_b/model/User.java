/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
@Entity
public class User  implements Serializable{
    @Id 
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String prenom;
@Email
private String email;
private String password;
private String telephone;
private String profession;

@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "utilisateur_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();



/*public Utilisateur(String nom, String prenom,String email, String password, String telephone){
this.nom = nom;
this.prenom = prenom;
this.email = email;
this.password = password;
this.telephone = telephone;
}*/
public User( String email, String password) {
		
		this.email = email;
		this.password = password;
	}

public User(){
}

    public User(String nom, String prenom, String telephone, String email, String password, String profession) {
this.nom = nom;
this.prenom = prenom;
this.email = email;
this.password = password;
this.telephone = telephone;
this.profession = profession;
    }
}
