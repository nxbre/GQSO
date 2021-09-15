package app;

import io.jooby.annotations.*;

@Path("/")
public class Controller {

  @GET
  public String welcome() {
    return "Bem-vindos a API calculadora!";
  }
}
