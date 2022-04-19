package com.moontech.library.exceptions.custom;

/**
 * Excepción de negocio.
 *
 * @author Felipe Monzón
 * @since Dec 18, 2021
 */
public class BusinessException extends RuntimeException {
  /** Serial. */
  private static final long serialVersionUID = -6450278167900735942L;
  /** Código de error. */
  private int code;

  /** Constructor de la clase. */
  public BusinessException() {
    super();
  }

  /**
   * Constructor de la clase.
   *
   * @param message mensaje de error
   */
  public BusinessException(String message) {
    super(message);
  }

  /**
   * Constructor de la clase.
   *
   * @param code código de error
   * @param message mensaje de error
   */
  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  /**
   * Obtiene el código de error
   *
   * @return código de error
   */
  public int getCode() {
    return code;
  }
}
