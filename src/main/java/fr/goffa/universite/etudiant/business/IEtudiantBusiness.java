package fr.goffa.universite.etudiant.business;

import java.util.List;

import fr.goffa.universite.etudiant.domain.Etudiant;

public interface IEtudiantBusiness {

	public List<Etudiant> getEtudiants();

	public Etudiant getEtudiant(Integer id);

	public void save(Etudiant etudiant);

	public void supEnseignant(Integer id);

}
