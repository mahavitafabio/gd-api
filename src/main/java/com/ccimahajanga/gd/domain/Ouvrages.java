package com.ccimahajanga.gd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ouvrages")
public class Ouvrages {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ouvrageId;
	private Integer codeOuvrages;
	private String titreOuvrages;
	private String domaines;
	private Integer nombreExemplaire;
	private Integer etage;
	private Integer ranger;
	private String commentaire;
	
	public Ouvrages() {
		
	}
	
	public Ouvrages(Integer ouvrageId, Integer codeOuvrages, String titreOuvrages, String domaines, Integer nombreExemplaire, Integer etage, Integer ranger, String commentaire) {
		super();
		this.ouvrageId = ouvrageId;
		this.codeOuvrages = codeOuvrages;
		this.domaines = domaines;
		this.titreOuvrages = titreOuvrages;
		this.etage = etage;
		this.ranger = ranger;
		this.nombreExemplaire = nombreExemplaire;
		this.commentaire = commentaire;
		}
		
	
	public Integer getOuvrageId() {
		return ouvrageId;
	}
	public void setOuvrageId(Integer ouvrageId) {
		this.ouvrageId = ouvrageId;
	}
	public Integer getCodeOuvrages() {
		return codeOuvrages;
	}
	public void setCodeOuvrages(Integer codeOuvrages) {
		this.codeOuvrages = codeOuvrages;
	}
	public String getTitreOuvrages() {
		return titreOuvrages;
	}
	public void setTitreOuvrages(String titreOuvrages) {
		this.titreOuvrages = titreOuvrages;
	}
	public String getDomaines() {
		return domaines;
	}
	public void setDomaines(String domaines) {
		this.domaines = domaines;
	}
	public Integer getNombreExemplaire() {
		return nombreExemplaire;
	}
	public void setNombreExemplaire(Integer nombreExemplaire) {
		this.nombreExemplaire = nombreExemplaire;
	}
	public Integer getEtage() {
		return etage;
	}
	public void setEtage(Integer etage) {
		this.etage = etage;
	}
	public Integer getRanger() {
		return ranger;
	}
	public void setRanger(Integer ranger) {
		this.ranger = ranger;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	@Override
	public String toString() {
		return "Ouvrages [ouvrageId=" + ouvrageId + ", codeOuvrages=" + codeOuvrages
				+ ", titreOuvrages=" + titreOuvrages + ", etage=" + etage + ", ranger="
				+ ranger + ", nombreExemplaire=" + nombreExemplaire + ", commentaire=" + commentaire + "]";
	}
	
}
