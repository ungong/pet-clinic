package guru.rcm.spfw.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.rcm.spfw.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
