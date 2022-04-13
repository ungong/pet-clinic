package guru.rcm.spfw.services;

import guru.rcm.spfw.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
}
