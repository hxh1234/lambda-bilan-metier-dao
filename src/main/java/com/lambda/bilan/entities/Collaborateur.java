package com.lambda.bilan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue( "COLLABORATEUR" )
public class Collaborateur extends Utilisateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date dateEmbaucheCollaborateur;
	@Temporal(TemporalType.DATE)
	private Date dateDepartCollaborateur;
	private String posteActuelCollaborateur;
	private Boolean etatCollaborateur=true;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idManagerRH")
	private ManagerRH managerRH;
	

	public Collaborateur() {
		super();
	}
	public Collaborateur(Long id) {
		super(id);
		this.etatCollaborateur=true;
	}
	public Date getDateEmbaucheCollaborateur() {
		return dateEmbaucheCollaborateur;
	}
	public void setDateEmbaucheCollaborateur(Date dateEmbaucheCollaborateur) {
		this.dateEmbaucheCollaborateur = dateEmbaucheCollaborateur;
	}
	public String getPosteActuelCollaborateur() {
		return posteActuelCollaborateur;
	}
	public void setPosteActuelCollaborateur(String posteActuelCollaborateur) {
		this.posteActuelCollaborateur = posteActuelCollaborateur;
	}
	public Boolean getEtatCollaborateur() {
		return etatCollaborateur;
	}
	public void setEtatCollaborateur(Boolean etatCollaborateur) {
		this.etatCollaborateur = etatCollaborateur;
	}
	public ManagerRH getManagerRH() {
		return managerRH;
	}
	public void setManagerRH(ManagerRH managerRH) {
		this.managerRH = managerRH;
	}
	public Date getDateDepartCollaborateur() {
		return dateDepartCollaborateur;
	}
	public void setDateDepartCollaborateur(Date dateDepartCollaborateur) {
		this.dateDepartCollaborateur = dateDepartCollaborateur;
	}
		

}
