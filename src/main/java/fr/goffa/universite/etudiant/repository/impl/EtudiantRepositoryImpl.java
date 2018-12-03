package fr.goffa.universite.etudiant.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.goffa.universite.etudiant.domain.Etudiant;
import fr.goffa.universite.etudiant.repository.IEtudiantRepository;

@Repository
public class EtudiantRepositoryImpl implements IEtudiantRepository {

	private static final String URL = "http://localhost:8080/etudiants/";

	@Override
	public List<Etudiant> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Etudiant> Liste = restTemplate
				.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Etudiant>>() {
				}).getBody();
		return Liste;

	}

	@Override
	public Etudiant getOne(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		Etudiant eT = restTemplate.getForObject(URL + id, Etudiant.class);
		return eT;
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		RestTemplate restTemplate = new RestTemplate();
		Etudiant eT = restTemplate.postForObject(URL, etudiant, Etudiant.class);
		return eT;
	}

	@Override
	public void deleteById(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL + id);
	}

}
