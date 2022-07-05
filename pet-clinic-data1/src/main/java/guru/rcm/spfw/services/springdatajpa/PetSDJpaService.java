package guru.rcm.spfw.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.rcm.spfw.model.Pet;
import guru.rcm.spfw.repositories.PetRepository;
import guru.rcm.spfw.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService{

	private final PetRepository petRepository;

	public PetSDJpaService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<Pet>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> optionalPet = petRepository.findById(id);
		
		if (optionalPet.isPresent()) {
			return optionalPet.get();
		} else {
			return null;
		}
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
		
	}
	
	
	
}
