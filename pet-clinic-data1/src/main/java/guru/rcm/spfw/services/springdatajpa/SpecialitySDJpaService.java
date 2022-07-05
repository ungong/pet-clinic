package guru.rcm.spfw.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.rcm.spfw.model.Speciality;
import guru.rcm.spfw.repositories.SpecialityRepository;
import guru.rcm.spfw.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService{

	private final SpecialityRepository specialityRepository;
		
	public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		Optional<Speciality> optionalSpeciality = specialityRepository.findById(id);
		
		if (optionalSpeciality.isPresent()) {
			return optionalSpeciality.get();
		} else {
			return null;
		}
	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
		
	}

	
	
}
