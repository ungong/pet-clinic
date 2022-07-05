package guru.rcm.spfw.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.rcm.spfw.model.Owner;
import guru.rcm.spfw.model.Pet;
import guru.rcm.spfw.model.PetType;
import guru.rcm.spfw.model.Speciality;
import guru.rcm.spfw.model.Vet;
import guru.rcm.spfw.model.Visit;
import guru.rcm.spfw.services.OwnerService;
import guru.rcm.spfw.services.PetService;
import guru.rcm.spfw.services.PetTypeService;
import guru.rcm.spfw.services.SpecialityService;
import guru.rcm.spfw.services.VetService;
import guru.rcm.spfw.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		
		if (count == 0) {
			loadData();
		}
	}
	
	
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);		
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("12344444");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(saveDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
//		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("12344444");
		
        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        
//        if (owner2.getPets() != null) {
        	owner2.getPets().add(fionasCat);	
//        } else {
//        	Set<Pet> fionasPets = new HashSet<Pet>();
//        	fionasPets.add(fionasCat);
//        	owner2.setPets(fionasPets);
//        }
        
        ownerService.save(owner2);
        
        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        
        visitService.save(catVisit);
                
        System.out.println("Loaded Owners....");        
        
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpeciality().add(savedRadiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		vetService.save(vet2);	
		System.out.println("Loaded Vets....");
	
		
		
		
	}

	
	
	 
}
