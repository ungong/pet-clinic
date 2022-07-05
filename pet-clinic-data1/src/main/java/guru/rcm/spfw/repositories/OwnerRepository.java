package guru.rcm.spfw.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.rcm.spfw.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByLastName(String lastName);
}
