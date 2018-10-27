package com.ccimahajanga.gd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Guide")
public class Guide {
	@Id
	@GeneratedValue
	private Integer guideId;
	private Integer codeOuvrages;
	private String titreOuvrages;
	private String domaines;
	private Integer nombreExemplaire;
	private Integer etage;
	private Integer ranger;
	private String commentaire;
	
	public Guide() {
		
	}
	
	public Guide(Integer guideId, Integer codeOuvrages, String titreOuvrages, String domaines, Integer nombreExemplaire, Integer etage, Integer ranger, String commentaire) {
		super();
		this.guideId = guideId;
		this.codeOuvrages = codeOuvrages;
		this.domaines = domaines;
		this.titreOuvrages = titreOuvrages;
		this.etage = etage;
		this.ranger = ranger;
		this.nombreExemplaire = nombreExemplaire;
		this.commentaire = commentaire;
		}
		
	
	public Integer getGuideId() {
		return guideId;
	}
	public void setGuideId(Integer guideId) {
		this.guideId = guideId;
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
		return "Guide [guideId=" + guideId + ", codeOuvrages=" + codeOuvrages
				+ ", titreOuvrages=" + titreOuvrages + ", etage=" + etage + ", ranger="
				+ ranger + ", nombreExemplaire=" + nombreExemplaire + ", commentaire=" + commentaire + "]";
	}
	
}
