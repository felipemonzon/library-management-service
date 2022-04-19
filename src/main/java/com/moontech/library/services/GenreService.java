package com.moontech.library.services;

import com.moontech.library.models.requests.Genre;
import com.moontech.library.models.responses.GenreResponse;
import org.springframework.data.domain.Pageable;

/**
 * Servicio de géneros de bibliotecarios.
 *
 * @author Felipe Monzón
 * @since Apr 18, 2022
 */
public interface GenreService {
  /**
   * Consulta un listado de géneros.
   *
   * @param pageable objeto de paginación {@code Pageable}
   * @return una lista de géneros.
   */
  GenreResponse retrieve(Pageable pageable);

  /**
   * Actualiza un autor.
   *
   * @param request DTO de géneros {@code Genre}
   * @param id identificador de un género.
   */
  void replaceGenre(Genre request, int id);

  /**
   * Guarda un género de libro.
   *
   * @param request DTO de géneros {@code Genre}
   */
  void saveGenre(Genre request);
}
