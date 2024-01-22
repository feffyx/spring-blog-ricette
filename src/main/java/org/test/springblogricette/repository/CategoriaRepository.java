package org.test.springblogricette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.springblogricette.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    void deleteById(Long id);
}

