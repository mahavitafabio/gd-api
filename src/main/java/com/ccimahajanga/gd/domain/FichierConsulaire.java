package com.ccimahajanga.gd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FichierConsulaire")
public class FichierConsulaire {
	@Id
	@GeneratedValue
	private Integer consulaireId;
	private String raisonSocial;
	private String sigle;
	private String formeJuridique;
	private String adresse;
	private String email;
	private Integer capital;
	private Integer numeroRegistre;
	private Integer numeroFiscal;
	private Integer numeroIdentite;
	private String updatedDate;
	private String createdDate;
	
	public FichierConsulaire() {}
	
	public FichierConsulaire(Integer consulaireId, String raisonSocial, String sigle, String formeJuridique, String adresse, String email,
			Integer capital, Integer numeroRegistre, Integer numeroFiscal, Integer numeroIdentite, String updateDate, String createDate) {
	super();
	this.consulaireId = consulaireId;
	this.capital = capital;
	this.adresse = adresse;
	this.createdDate = createDate;
	this.updatedDate = updateDate;
	this.email = email;
	this.formeJuridique = formeJuridique;
	this.numeroFiscal = numeroFiscal;
	this.numeroIdentite = numeroIdentite;
	this.numeroRegistre = numeroRegistre;
	this.raisonSocial = raisonSocial;
	this.sigle = sigle;
	}

	public Integer getConsulaireId() {
		return consulaireId;
	}

	public void setConsulaireId(Integer consulaireId) {
		this.consulaireId = consulaireId;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public Integer getNumeroRegistre() {
		return numeroRegistre;
	}

	public void setNumeroRegistre(Integer numeroRegistre) {
		this.numeroRegistre = numeroRegistre;
	}

	public Integer getNumeroFiscal() {
		return numeroFiscal;
	}

	public void setNumeroFiscal(Integer numeroFiscal) {
		this.numeroFiscal = numeroFiscal;
	}

	public Integer getNumeroIdentite() {
		return numeroIdentite;
	}

	public void setNumeroIdentite(Integer numeroIdentite) {
		this.numeroIdentite = numeroIdentite;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updateDate) {
		this.updatedDate = updateDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createDate) {
		this.createdDate = createDate;
	}
	
	@Override
	public String toString() {
		return "FichierConsulaire [consulaireId=" + consulaireId + ", capital=" + capital 
				+ ", adresse=" + adresse + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate 
				+ ", email=" + email + ", formeJuridique=" + formeJuridique
				+ ", numeroFiscal=" + numeroFiscal + ", formeJuridique=" + formeJuridique + ", numeroFiscal="
				+ numeroFiscal + ", numeroIdentite=" + numeroIdentite + ", numeroRegistre=" + numeroRegistre 
				+ ", raisonSocial=" + raisonSocial + ", sigle=" + sigle + "]";
	} 
	
}
