package com.ccimahajanga.gd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Services")
public class Chervice {
	@Id
	@GeneratedValue
	private Integer servicesId;
	private String nomEntreprise;
	private String adresseEntreprise;
	private String contact;
	private String nomResponsable;
	private String activitePrincipale;

	public Chervice() {

	}

	public Chervice(Integer servicesId, String nomEntreprise, String adresseEntreprise, String contact,
			String nomResponsable, String activitePrincipale) {
		super();
		this.servicesId = servicesId;
		this.nomEntreprise = nomEntreprise;
		this.adresseEntreprise = adresseEntreprise;
		this.contact = contact;
		this.nomResponsable = nomResponsable;
		this.activitePrincipale = activitePrincipale;
	}

	public Integer getServicesId() {
		return servicesId;
	}

	public void setServicesId(Integer servicesId) {
		this.servicesId = servicesId;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
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

	@Override
	public String toString() {
		return "Chervice [servicesId=" + servicesId + ", nomEntreprise=" + nomEntreprise
				+ ", adresseEntreprise=" + adresseEntreprise + ", contact=" + contact + ", nomResponsable="
				+ nomResponsable + ", activitePrincipale=" + activitePrincipale + "]";
	}
}
