package com.moontech.library.models.responses;

import com.moontech.library.models.requests.Genre;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Respuesta de la API GENRE-RETRIEVE.
 *
 * @author Felipe Monzón
 * @since Apr 18, 2022
 */
@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class GenreResponse extends Pagination {
  /** Lista de géneros. */
  List<Genre> genres;
}
