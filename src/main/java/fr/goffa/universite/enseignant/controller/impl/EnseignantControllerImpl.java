
package fr.goffa.universite.enseignant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.goffa.universite.enseignant.business.IEnseignantBusiness;
import fr.goffa.universite.enseignant.controller.IEnseignantController;
import fr.goffa.universite.enseignant.domain.Enseignant;

@Controller
public class EnseignantControllerImpl implements IEnseignantController {

	@Autowired
	private IEnseignantBusiness enseignantBuisiness;

	@Override
	@RequestMapping("/enseignants")
	public String list(Model model) {
		List<Enseignant> enseignants = enseignantBuisiness.getEnseignants();
		model.addAttribute("enseignants", enseignants);

		return "enseignant/enseignants";
	}

	@Override
	@RequestMapping("/enseignant")

	public String getEnseignantById(Model model, @RequestParam Integer id) {
		Enseignant e = enseignantBuisiness.getEnseignant(id);
		model.addAttribute("enseignant", e);

		return "enseignant/enseignant";
	}

	@Override
	@RequestMapping("/ajout")

	public String ajouterEnseignant(Model model) {

		return "enseignant/ajouterEnseignant";
	}

	@Override
	@RequestMapping("/ajouterEnseignant")
	public String ajouterFormulaireEnseignant(Model model) {
		Enseignant e = new Enseignant();
		model.addAttribute("enseignant", e);

		return "enseignant/ajouterEnseignant";

	}

	@Override
	@PostMapping("/addEnseignant")
	public String ajouterEnseignant(Model model, @ModelAttribute Enseignant enseignant) {
		enseignantBuisiness.saveEnseignant(enseignant);

		return "redirect:/enseignants";
	}

	@Override
	@RequestMapping("/supEnseignant")
	public String supEnseignant(Model model, @RequestParam Integer id) {
		enseignantBuisiness.supEnseignant(id);

		return "redirect:/enseignants";

	}

}
