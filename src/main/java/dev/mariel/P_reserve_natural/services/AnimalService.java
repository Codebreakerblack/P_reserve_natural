package dev.mariel.P_reserve_natural.services;

import dev.mariel.P_reserve_natural.models.Animal;
import dev.mariel.P_reserve_natural.repositories.AnimalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Animal> animalPage = animalRepository.findAll(pageable);
        return animalPage.getContent();
    }

    public List<Animal> getAnimalsByFamily(String familyName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Animal> familyPage = animalRepository.findByFamily(familyName, pageable);
        return familyPage.getContent();
    }

    public List<Animal> getAnimalsByCountry(String countryName) {
        return animalRepository.findByCountryOrigin(countryName);
    }

    public List<Animal> getAnimalsByTypeAndFamily(String type, String family) {
        return animalRepository.findByFamilyAndType(family, type);
    }

    public long getAnimalCount() {
        return animalRepository.count();
    }

    public Animal getAnimalByName(String name) {
        return animalRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Animal no encontrado con nombre: " + name));
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long id, Animal updatedAnimal) {
        return animalRepository.findById(id)
                .map(animal -> {
                    animal.setName(updatedAnimal.getName());
                    animal.setType(updatedAnimal.getType());
                    animal.setFamily(updatedAnimal.getFamily());
                    animal.setGender(updatedAnimal.getGender());
                    animal.setCountryOrigin(updatedAnimal.getCountryOrigin());
                    animal.setEntryDate(updatedAnimal.getEntryDate());
                    animal.setPicture(updatedAnimal.getPicture());
                    return animalRepository.save(animal);
                })
                .orElseThrow(() -> new RuntimeException("Animal no encontrado con ID: " + id));
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}