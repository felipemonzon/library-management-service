package com.moontech.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moontech.library.constants.DatabaseConstant;
import com.moontech.library.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Entidad de géneros.
 *
 * @author Felipe Monzón
 * @since Apr 18. 2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = DatabaseConstant.GENRES_TABLE)
@Table(name = DatabaseConstant.GENRES_TABLE)
public class GenreEntity extends AuditableEntity {
  /** Identificador de la tabla. */
  @Id
  @Column(name = DatabaseConstant.AUTHOR_ID_FIELD)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  /** Propiedad para la descripción de los géneros. */
  @Column(name = DatabaseConstant.DESCRIPTION_FIELD, nullable = false, unique = true)
  private String description;
  /** Status del género. */
  @Enumerated(EnumType.ORDINAL)
  private Status status;
  /** Relación para la tabla de libros. */
  @JsonIgnore
  @ManyToMany(
      mappedBy = DatabaseConstant.AUTHORS_TABLE,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<BookEntity> books;
}
