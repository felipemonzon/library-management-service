package com.moontech.library.business;

import com.moontech.library.constants.ErrorConstant;
import com.moontech.library.entities.GenreEntity;
import com.moontech.library.exceptions.custom.NotDataFoundException;
import com.moontech.library.models.requests.Genre;
import com.moontech.library.models.responses.GenreResponse;
import com.moontech.library.repositories.GenreRepository;
import com.moontech.library.services.GenreService;
import com.moontech.library.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación de las reglas de negocio.
 *
 * @author Felipe Monzón
 * @since Apr 18, 2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GenreBusiness implements GenreService {
  /** Repositorio para géneros. */
  private final GenreRepository genreRepository;

  /** {@inheritDoc}. */
  @Override
  @Transactional
  public void saveGenre(Genre request) {
    log.debug("Guarda los datos de un género {}", request.toString());
    this.genreRepository.save(this.mapping(request));
  }

  /** {@inheritDoc}. */
  @Override
  @Modifying
  @Transactional
  public void replaceGenre(Genre request, int id) {
    this.validatePublisher(id);
    request.setId(id);
    log.debug("Actualiza los datos de un género {}", request);
    this.genreRepository.save(this.mapping(request));
  }

  /** {@inheritDoc}. */
  @Override
  @Transactional(readOnly = true)
  public GenreResponse retrieve(Pageable pageable) {
    int page = Utilities.getCurrentPage(pageable);
    log.info("Consulta géneros por página {}", page);
    Page<Genre> genres =
        this.genreRepository
            .findAll(PageRequest.of(page, pageable.getPageSize()))
            .map(this::mapping);
    return GenreResponse.builder()
        .genres(genres.getContent())
        .currentPage(page)
        .firstPage(genres.isFirst())
        .lastPage(genres.isLast())
        .totalPages(genres.getTotalPages())
        .build();
  }

  /**
   * Válida que exista un género.
   *
   * @param id identificador del género
   */
  private void validatePublisher(int id) {
    this.genreRepository
        .findById(id)
        .<NotDataFoundException>orElseThrow(
            () -> {
              throw new NotDataFoundException(ErrorConstant.RECORD_NOT_FOUND_MESSAGE);
            });
  }

  /**
   * Convierte un objeto {@code Genre} a una entidad de tipo {@code GenreEntity}
   *
   * @param request objeto de tipo {@link Genre}
   * @return una entidad de género
   */
  private GenreEntity mapping(Genre request) {
    return new ModelMapper().map(request, GenreEntity.class);
  }

  /**
   * Convierte una entidad {@code GenreEntity} a uno de tipo {@code Genre}
   *
   * @param entity objeto de tipo {@link Genre}
   * @return objeto de salida de la api de géneros
   */
  private Genre mapping(GenreEntity entity) {
    return new ModelMapper().map(entity, Genre.class);
  }
}
