package fr.goffa.universite.enseignant.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.goffa.universite.enseignant.business.IEnseignantBusiness;
import fr.goffa.universite.enseignant.domain.Enseignant;
import fr.goffa.universite.enseignant.repository.IEnseignantRepository;

@Service
public class EnseignantBusinessImpl implements IEnseignantBusiness {

	@Autowired
	private IEnseignantRepository enseignantRepository;

	@Override
	public List<Enseignant> getEnseignants() {
		List<Enseignant> enseignantListe = enseignantRepository.findAll();

		return enseignantListe;
	}

	@Override
	public Enseignant getEnseignant(Integer id) {
		Enseignant e = enseignantRepository.getOne(id);
		return e;
	}

	@Override
	public void saveEnseignant(Enseignant enseignant) {
		enseignantRepository.save(enseignant);

	}

	@Override
	public void supEnseignant(Integer id) {
		enseignantRepository.deleteById(id);
	}

}
