package com.moontech.library.repositories;

import com.moontech.library.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de géneros.
 *
 * @author Felipe Monzón
 * @since Apr 18. 2022
 */
@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {}
