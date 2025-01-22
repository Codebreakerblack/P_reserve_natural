package dev.mariel.P_reserve_natural.repositories;

import dev.mariel.P_reserve_natural.models.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Solicitudes públicas
    @NonNull
    Page<Animal> findAll(@NonNull Pageable pageable);

    @NonNull
    Page<Animal> findByFamily(@NonNull String family, @NonNull Pageable pageable);

    @NonNull
    List<Animal> findByCountryOrigin(@NonNull String countryOrigin);

    @NonNull
    List<Animal> findByFamilyAndType(@NonNull String family, @NonNull String type);

    // Solicitudes privadas
    Optional<Animal> findByName(String name);
}
