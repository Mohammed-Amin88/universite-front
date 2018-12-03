package fr.goffa.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.goffa.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {

	public String list(Model model);

	public String getEnseignantById(Model model, Integer id);

	public String ajouterEnseignant(Model model);

	public String ajouterFormulaireEnseignant(Model model);

	public String ajouterEnseignant(Model model, Enseignant enseignant);

	public String supEnseignant(Model model, Integer id);

}
