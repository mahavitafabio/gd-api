package com.ccimahajanga.gd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ccimahajanga.gd.domain.Entreprises;
import com.ccimahajanga.gd.domain.FichierConsulaire;
import com.ccimahajanga.gd.domain.Ouvrages;
import com.ccimahajanga.gd.service.EntreprisesRepository;
import com.ccimahajanga.gd.service.FichierConsulaireRepository;
import com.ccimahajanga.gd.service.OuvragesRepository;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	@Bean
	public CommandLineRunner demo(EntreprisesRepository repository, OuvragesRepository ouvragesRepository, FichierConsulaireRepository fichierConsulaireRepository ) {
		return (args) -> {
			for (Entreprises entreprise : repository.findAll()) {
			System.out.println(entreprise.getEntreprisesId()+ ":" + entreprise.getNomEntreprise());
			System.out.println(entreprise.getNomResponsable());
			System.out.println(entreprise.getContact());
			System.out.println(entreprise.getActivitePrincipale());
			System.out.println(entreprise.getAdresseEntreprise());
			}
			
			for (Ouvrages ouvrage : ouvragesRepository.findAll()) {
				System.out.println(ouvrage.getOuvrageId());
				System.out.println(ouvrage.getCodeOuvrages());
				System.out.println(ouvrage.getDomaines());
				System.out.println(ouvrage.getNombreExemplaire());
				System.out.println(ouvrage.getEtage());
				System.out.println(ouvrage.getRanger());
				System.out.println(ouvrage.getTitreOuvrages());
				System.out.println(ouvrage.getCommentaire());
			}
			for (FichierConsulaire fichierConsulaire : fichierConsulaireRepository.findAll()) {
				System.out.println(fichierConsulaire.getConsulaireId());
				System.out.println(fichierConsulaire.getAdresse());
				System.out.println(fichierConsulaire.getEmail());
				System.out.println(fichierConsulaire.getCreatedDate());
				System.out.println(fichierConsulaire.getNumeroFiscal());
				System.out.println(fichierConsulaire.getFormeJuridique());
				System.out.println(fichierConsulaire.getNumeroRegistre());
				System.out.println(fichierConsulaire.getRaisonSocial());
				System.out.println(fichierConsulaire.getSigle());
				System.out.println(fichierConsulaire.getUpdatedDate());
				System.out.println(fichierConsulaire.getNumeroIdentite());
				System.out.println(fichierConsulaire.getCapital());
				
			}
		};
}
	}
