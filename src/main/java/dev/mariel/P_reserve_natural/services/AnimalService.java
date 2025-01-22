package dev.mariel.P_reserve_natural.services;

import dev.mariel.P_reserve_natural.models.Animal;
import dev.mariel.P_reserve_natural.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long id, Animal updatedAnimal) {
        return animalRepository.findById(id).map(animal -> {
            animal.setName(updatedAnimal.getName());
            animal.setType(updatedAnimal.getType());
            animal.setFamily(updatedAnimal.getFamily());
            animal.setGender(updatedAnimal.getGender());
            animal.setCountryOrigin(updatedAnimal.getCountryOrigin());
            animal.setEntryDate(updatedAnimal.getEntryDate());
            animal.setPicture(updatedAnimal.getPicture());
            return animalRepository.save(animal);
        }).orElseThrow(() -> new RuntimeException("Animal no encontrado con ID: " + id));
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}