package com.senac.starter.repositorys;

import com.senac.starter.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Animal findAnimalById(Long id);
}
