package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma {
    @Path("/soma/{a}/{b}")
    @GET
    public String soma(@PathParam String a, @PathParam String b) {
        try {

            double soma = Double.parseDouble(a) + Double.parseDouble(b);
            return String.format("%.2f", soma);

        } catch (NumberFormatException nfe) {
            throw new BadRequestException(String.format("Parâmetros inválidos: %s e %s.", a, b));
        }
    }

}
