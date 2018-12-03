package fr.goffa.universite.enseignant.business;

import java.util.List;

import fr.goffa.universite.enseignant.domain.Enseignant;

public interface IEnseignantBusiness {

	public List<Enseignant> getEnseignants();

	public Enseignant getEnseignant(Integer id);

	public void saveEnseignant(Enseignant enseignant);

	public void supEnseignant(Integer id);

}
