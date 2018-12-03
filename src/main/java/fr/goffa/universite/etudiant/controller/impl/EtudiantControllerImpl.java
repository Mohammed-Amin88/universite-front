package fr.goffa.universite.etudiant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.goffa.universite.etudiant.business.IEtudiantBusiness;
import fr.goffa.universite.etudiant.controller.IEtudiantController;
import fr.goffa.universite.etudiant.domain.Etudiant;

@Controller
public class EtudiantControllerImpl<Etudiants> implements IEtudiantController {
	@Autowired
	private IEtudiantBusiness etudiantBusiness;

	private final String ETUDIANT_ATTR = "etudiant";
	private final String ETUDIANTS_REDIRECT = "redirect:/etudiants";

	@Override
	@RequestMapping("/etudiants")
	public String getEtudiants(Model model) {
		List<Etudiant> etudiants = etudiantBusiness.getEtudiants();
		model.addAttribute("etudiants", etudiants);
		return "etudiant/etudiants";

	}

	@Override
	@RequestMapping("/etudiant")
	public String getEtudiantById(Model model, @RequestParam Integer id) {
		Etudiant eT = etudiantBusiness.getEtudiant(id);
		model.addAttribute(ETUDIANT_ATTR, eT);

		return "etudiant/etudiant";
	}

	@Override
	@RequestMapping("/ajouterEtudiant")
	public String ajouterFormulaireEtudiant(Model model) {
		Etudiant eT = new Etudiant();
		model.addAttribute("etudiant", eT);
		return "etudiant/ajouterEtudiant";

	}

	@Override
	@PostMapping("/addEtudiant")
	public String ajouterEtudiant(Model model, @ModelAttribute Etudiant etudiant) {
		etudiantBusiness.save(etudiant);
		return ETUDIANTS_REDIRECT;
	}

	@Override
	@PostMapping("/modifierEtudiant")
	public String modifierEtudiant(Model model, @ModelAttribute Etudiant etudiant) {
		etudiantBusiness.save(etudiant);
		return ETUDIANTS_REDIRECT;
	}

	@Override
	@GetMapping("/modifierEtudiant")
	public String modifierFormulaireEtudiant(Model model, @RequestParam Integer id) {
		Etudiant eT = etudiantBusiness.getEtudiant(id);
		model.addAttribute(ETUDIANT_ATTR, eT);
		return "etudiant/modifierEtudiant";
	}

	@Override
	@RequestMapping("/supEtudiant")
	public String supEtudiant(Model model, @RequestParam Integer id) {
		etudiantBusiness.supEnseignant(id);

		return ETUDIANTS_REDIRECT;

	}

}
