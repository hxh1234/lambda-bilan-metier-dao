package com.lambda.bilan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Objectif implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idObjectif;
	private Date dateCreationObjectif;
	private String nomObjectif;
	private String descriptifObjectif;
	private String statutObjectif;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCollaborateur")
	private Collaborateur collaborateur;
	
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategorie")
	private Categorie categorie;
	
	// clés étrangères
	@Column(name = "idCollaborateur", insertable = false, updatable = false)
	private Long idCollaborateur;
	
	@Column(name = "idCategorie", insertable = false, updatable = false)
	private Long idCategorie;
	
	public Objectif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdObjectif() {
		return idObjectif;
	}
	public void setIdObjectif(Long idObjectif) {
		this.idObjectif = idObjectif;
	}
	public Date getDateCreationObjectif() {
		return dateCreationObjectif;
	}
	public void setDateCreationObjectif(Date dateCreationObjectif) {
		this.dateCreationObjectif = dateCreationObjectif;
	}
	public String getNomObjectif() {
		return nomObjectif;
	}
	public void setNomObjectif(String nomObjectif) {
		this.nomObjectif = nomObjectif;
	}
	public String getStatutObjectif() {
		return statutObjectif;
	}
	public void setStatutObjectif(String statutObjectif) {
		this.statutObjectif = statutObjectif;
	}
	public String getDescriptifObjectif() {
		return descriptifObjectif;
	}
	public void setDescriptifObjectif(String descriptifObjectif) {
		this.descriptifObjectif = descriptifObjectif;
	}
	

}
