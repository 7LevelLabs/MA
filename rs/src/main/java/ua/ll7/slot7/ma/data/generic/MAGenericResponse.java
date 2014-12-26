package ua.ll7.slot7.ma.data.generic;

import ua.ll7.slot7.ma.util.MAStatusCode;

/**
 * MA
 * Velichko A.
 * 26.12.14 18:14
 */
public class MAGenericResponse {
  private String       message    = "";
  private MAStatusCode statusCode = MAStatusCode.OK;

  public MAGenericResponse() {
  }

  public MAGenericResponse(String message, MAStatusCode statusCode) {
    this.message = message;
    this.statusCode = statusCode;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("MAResponse{");
    sb.append("message='").append(message).append('\'');
    sb.append(", statusCode=").append(statusCode);
    sb.append('}');
    return sb.toString();
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public MAStatusCode getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(MAStatusCode statusCode) {
    this.statusCode = statusCode;
  }
}
