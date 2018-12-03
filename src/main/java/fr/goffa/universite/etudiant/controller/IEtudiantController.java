package fr.goffa.universite.etudiant.controller;

import org.springframework.ui.Model;

import fr.goffa.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {

	public String getEtudiants(Model model);

	public String getEtudiantById(Model model, Integer id);

	public String ajouterFormulaireEtudiant(Model model);

	public String ajouterEtudiant(Model model, Etudiant etudiant);

	public String modifierEtudiant(Model model, Etudiant etudiant);

	public String modifierFormulaireEtudiant(Model model, Integer id);

	public String supEtudiant(Model model, Integer id);

}
