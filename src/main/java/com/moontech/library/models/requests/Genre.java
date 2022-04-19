package com.moontech.library.models.requests;

import com.moontech.library.enums.Status;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Petición para las APIS de géneros.
 *
 * @author Felipe Monzón
 * @since Apr. 29, 2022
 */
@Data
public class Genre {
  /** Identificador de la tabla. */
  private int id;
  /** Propiedad para la descripción del género. */
  @NotEmpty private String description;
  /** Status del autor. */
  private Status status;
}
