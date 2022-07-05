package guru.rcm.spfw.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.rcm.spfw.model.Vet;
import guru.rcm.spfw.repositories.VetRepository;
import guru.rcm.spfw.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{

	private final VetRepository vetRepository;
	
	public VetSDJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<Vet>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		Optional<Vet> optionalVet = vetRepository.findById(id);
		
		if (optionalVet.isPresent()) {
			return optionalVet.get();
		} else {
			return null;
		}
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);		
	}

}
