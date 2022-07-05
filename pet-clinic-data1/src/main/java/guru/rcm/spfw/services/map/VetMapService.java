package guru.rcm.spfw.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.rcm.spfw.model.Speciality;
import guru.rcm.spfw.model.Vet;
import guru.rcm.spfw.services.SpecialityService;
import guru.rcm.spfw.services.VetService;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{

	private final SpecialityService specialityService;
	
	public VetMapService(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {
		if (object.getSpeciality().size() > 0){
			object.getSpeciality().forEach(speciality -> {
            if(speciality.getId() == null){
                Speciality savedSpecialty = specialityService.save(speciality);
                speciality.setId(savedSpecialty.getId());
            }
        });
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}
