package com.moontech.library.apis;

import com.moontech.library.constants.RoutesConstant;
import com.moontech.library.models.requests.Genre;
import com.moontech.library.models.responses.GenreResponse;
import com.moontech.library.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * APIS para el módulo de géneros.
 *
 * @author Felipe Monzón
 * @since Apr 18. 2021
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RoutesConstant.GENRES_BASE_PATH)
public class GenreController {
  /** Servicio de géneros. */
  private final GenreService genreService;

  /**
   * API para consultar lso géneros.
   *
   * @param pageable objeto de paginación {@code Pageable}
   * @return lista de géneros
   */
  @GetMapping(path = RoutesConstant.DATA_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GenreResponse> retrieve(@PageableDefault() Pageable pageable) {
    return ResponseEntity.ok(this.genreService.retrieve(pageable));
  }

  /**
   * API para guardar un género.
   *
   * @param request objeto {@code Genre} de la API de géneros
   * @return HttpStatus CREATED cuando el género se guardó correctamente
   */
  @PostMapping(
      path = RoutesConstant.DATA_CREATE_PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> save(@RequestBody @Valid Genre request) {
    this.genreService.saveGenre(request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * API para actualizar un género.
   *
   * @param request entrada de la API {@code Genre}
   * @param id identificador del género
   * @return HttpStatus NO_CONTENT si se actualizo con éxito
   */
  @PutMapping(
      path = RoutesConstant.DATA_MODIFIED_PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> update(@RequestBody @Valid Genre request, @PathVariable int id) {
    this.genreService.replaceGenre(request, id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
