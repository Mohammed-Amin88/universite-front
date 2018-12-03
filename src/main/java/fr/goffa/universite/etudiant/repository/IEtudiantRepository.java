package fr.goffa.universite.etudiant.repository;

import java.util.List;

import fr.goffa.universite.etudiant.domain.Etudiant;

public interface IEtudiantRepository {

	public List<Etudiant> findAll();

	public Etudiant getOne(Integer id);

	public Etudiant save(Etudiant etudiant);

	public void deleteById(Integer id);

}
