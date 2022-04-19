package com.moontech.library.exceptions.custom;

/**
 * Excepción para datos no encontrados.
 *
 * @author Felipe Monzón
 * @since Dec 18, 2021
 */
public class NotDataFoundException extends RuntimeException {
  /** Serial. */
  private static final long serialVersionUID = -6450278167900735942L;

  /** Constructor de la clase. */
  public NotDataFoundException() {
    super();
  }

  /**
   * Constructor de la clase.
   *
   * @param message mensaje de error
   */
  public NotDataFoundException(String message) {
    super(message);
  }
}
