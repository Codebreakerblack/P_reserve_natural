package dev.mariel.P_reserve_natural.controllers;

import dev.mariel.P_reserve_natural.models.Animal;
import dev.mariel.P_reserve_natural.services.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAllAnimals(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return animalService.getAllAnimals(page, size);
    }

    @GetMapping("/family/{familyName}")
    public List<Animal> getAnimalsByFamily(@PathVariable String familyName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return animalService.getAnimalsByFamily(familyName, page, size);
    }

    @GetMapping("/country/{countryName}")
    public List<Animal> getAnimalsByCountry(@PathVariable String countryName) {
        return animalService.getAnimalsByCountry(countryName);
    }

    @GetMapping("/type/{type}")
    public List<Animal> getAnimalsByTypeAndFamily(@RequestParam String family,
            @PathVariable String type) {
        return animalService.getAnimalsByTypeAndFamily(type, family);
    }

    // Endpoint para obtener el conteo total de animales
    @GetMapping("/count")
    public long getAnimalCount() {
        return animalService.getAnimalCount();
    }

    @GetMapping("/{name}")
    public Animal getAnimalByName(@PathVariable String name) {
        return animalService.getAnimalByName(name);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        return animalService.updateAnimal(id, updatedAnimal);
    }
}
