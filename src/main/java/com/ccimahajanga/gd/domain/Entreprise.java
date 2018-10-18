package com.ccimahajanga.gd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Entreprises")
public class Entreprise {
	@Id
	@GeneratedValue
	private Integer entreprisesId;
	private String nomEntreprise;
	private String adresseEntreprise;
	private String contact;
	private String nomResponsable;
	private String activitePrincipale;

	public Entreprise() {

	}

	public Entreprise(Integer entreprisesId, String nomEntreprise, String adresseEntreprise, String contact,
			String nomResponsable, String activitePrincipale) {
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
		return "Entreprise [entreprisesId=" + entreprisesId + ", nomEntreprise=" + nomEntreprise
				+ ", adresseEntreprise=" + adresseEntreprise + ", contact=" + contact + ", nomResponsable="
				+ nomResponsable + ", activitePrincipale=" + activitePrincipale + "]";
	}
}
