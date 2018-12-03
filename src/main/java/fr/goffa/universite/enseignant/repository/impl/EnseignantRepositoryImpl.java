package fr.goffa.universite.enseignant.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.goffa.universite.enseignant.domain.Enseignant;
import fr.goffa.universite.enseignant.repository.IEnseignantRepository;

@Repository
public class EnseignantRepositoryImpl implements IEnseignantRepository {
	private static final String URL = "http://localhost:8080/enseignants/";

	@Override
	public List<Enseignant> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Enseignant> liste = restTemplate
				.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Enseignant>>() {
				}).getBody();

		return liste;
	}

	@Override
	public Enseignant getOne(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		Enseignant e = restTemplate.getForObject(URL + id, Enseignant.class);
		return e;
	}

	@Override
	public Enseignant save(Enseignant enseignant) {
		RestTemplate restTemplate = new RestTemplate();
		Enseignant e = restTemplate.postForObject(URL, enseignant, Enseignant.class);
		return e;

	}

	@Override
	public void deleteById(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL + id);
	}

}
