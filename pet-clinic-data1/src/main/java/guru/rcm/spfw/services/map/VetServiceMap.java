package guru.rcm.spfw.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.rcm.spfw.model.Vet;
import guru.rcm.spfw.services.CrudService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long>{

	@Override
	public Vet save(Vet object) {
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
