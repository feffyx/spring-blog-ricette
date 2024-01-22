package org.test.springblogricette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.springblogricette.model.Ricetta;

public interface RicettaRepository extends JpaRepository<Ricetta, Long> {
}
