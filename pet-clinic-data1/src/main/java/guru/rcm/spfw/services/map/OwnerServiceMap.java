package guru.rcm.spfw.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.rcm.spfw.model.Owner;
import guru.rcm.spfw.services.CrudService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long>{

	@Override
	public Owner save(Owner object) {
		return super.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}
	

}
