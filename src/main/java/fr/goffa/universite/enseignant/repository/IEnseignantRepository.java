package fr.goffa.universite.enseignant.repository;

import java.util.List;

import fr.goffa.universite.enseignant.domain.Enseignant;

public interface IEnseignantRepository {

	public List<Enseignant> findAll();

	public Enseignant getOne(Integer id);

	public Enseignant save(Enseignant enseignant);

	public void deleteById(Integer id);

}
