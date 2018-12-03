package fr.goffa.universite.etudiant.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.goffa.universite.etudiant.business.IEtudiantBusiness;
import fr.goffa.universite.etudiant.domain.Etudiant;
import fr.goffa.universite.etudiant.repository.IEtudiantRepository;

@Service
public class EtudiantBusinessImpl implements IEtudiantBusiness {
	@Autowired
	private IEtudiantRepository etudiantRepository;

	@Override
	public List<Etudiant> getEtudiants() {
		List<Etudiant> etudiantListe = etudiantRepository.findAll();
		return etudiantListe;
	}

	@Override
	public Etudiant getEtudiant(Integer id) {
		Etudiant etudiant = etudiantRepository.getOne(id);
		return etudiant;
	}

	@Override
	public void save(Etudiant etudiant) {
		etudiantRepository.save(etudiant);
	}

	@Override
	public void supEnseignant(Integer id) {
		etudiantRepository.deleteById(id);

	}

}
