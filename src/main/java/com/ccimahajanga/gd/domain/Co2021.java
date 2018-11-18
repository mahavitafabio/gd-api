package com.ccimahajanga.gd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Co2021")
public class Co2021 {
	@Id
	 @GeneratedValue
	 private Integer co2021Id;
	 private Integer numero;
	 private String date;
	 private String nomEntreprise;
	 private String adresse;
	 private String destination;
	 private String produit;
	 private Integer quantiteExporte;
	 private String unite;
	 private Integer nombreConteneur;
	 private String prixUnitaire;
	 private String montant;
	 
	 public Co2021() {
		 
	 }
	 public Co2021(Integer co2021Id, Integer numero, String date, String nomEntreprise, String adresse, String destination, String produit, Integer quantiteExporte, String unite, Integer nombreConteneur, String prixUnitaire, String montant) {
		 super();
		 this.co2021Id = co2021Id;
		 this.numero = numero;
		 this.date = date;
		 this.nomEntreprise = nomEntreprise;
		 this.adresse = adresse;
		 this.destination = destination;
		 this.produit = produit;
		 this.quantiteExporte = quantiteExporte;
		 this.unite = unite;
		 this.nombreConteneur = nombreConteneur;
		 this.prixUnitaire = prixUnitaire;
		 this.montant = montant;
		 
	 }
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getCo2021Id() {
		return co2021Id;
	}
	public void setCo2021Id(Integer co2021Id) {
		this.co2021Id = co2021Id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	public Integer getQuantiteExporte() {
		return quantiteExporte;
	}
	public void setQuantiteExporte(Integer quantiteExporte) {
		this.quantiteExporte = quantiteExporte;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public Integer getNombreConteneur() {
		return nombreConteneur;
	}
	public void setNombreConteneur(Integer nombreConteneur) {
		this.nombreConteneur = nombreConteneur;
	}
	public String getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(String prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	 
	@Override
	public String toString() {
		return "Co2021 [co2021Id=" + co2021Id + ", numero=" + numero
				+ ", date=" + date + ", nomEntreprise=" + nomEntreprise + ", adresse="
				+ adresse + ", destination=" + destination + ", produit=" + produit 
				+ ", quantiteExporte=" + quantiteExporte + ", unite=" + unite + ", nombreConteneur="
				+ nombreConteneur + ", prixUnitaire=" + prixUnitaire + ", montant=" + montant + "]";
	} 

}
