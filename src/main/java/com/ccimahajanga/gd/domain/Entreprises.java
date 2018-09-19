package com.ccimahajanga.gd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entreprises {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
 private Integer entreprisesId;
 private String nomEntreprise;
 private String adresseEntreprise;
 private Integer contact;
 private String nomResponsable;
 private String activitePrincipale;
 
 public Entreprises() {
	 
 }
public Entreprises(Integer entreprisesId, String nomEntreprise, String adresseEntreprise, Integer contact, String nomResponsable, String activitePrincipale) {
	super();
	this.entreprisesId = entreprisesId;
	this.nomEntreprise = nomEntreprise;
	this.adresseEntreprise = adresseEntreprise;
	this.contact = contact;
	this.nomResponsable = nomResponsable;
	this.activitePrincipale = activitePrincipale;
}

public Integer getEntreprisesId() {
	return entreprisesId;
}
public void setEntreprisesId(Integer entreprisesId) {
	this.entreprisesId = entreprisesId;
}
public String getNomEntreprise() {
	return nomEntreprise;
}
public void setNomEntreprise(String nomEntreprise) {
	this.nomEntreprise = nomEntreprise;
}
public String getAdresseEntreprise() {
	return adresseEntreprise;
}
public void setAdresseEntreprise(String adresseEntreprise) {
	this.adresseEntreprise = adresseEntreprise;
}
public Integer getContact() {
	return contact;
}
public void setContact(Integer contact) {
	this.contact = contact;
}
public String getNomResponsable() {
	return nomResponsable;
}
public void setNomResponsable(String nomResponsable) {
	this.nomResponsable = nomResponsable;
}
public String getActivitePrincipale() {
	return activitePrincipale;
}
public void setActivitePrincipale(String activitePrincipale) {
	this.activitePrincipale = activitePrincipale;
}
 
 
}
