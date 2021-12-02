package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma {
    @Path("/soma/{a}/{b}")
    @GET
    public String soma(@PathParam String a, @PathParam String b) 
    throws BadRequestException {
        try {

            double soma = soma(a,b);
            return String.format("%.2f", soma);

        } catch (IllegalArgumentException iae) {
            throw new BadRequestException(iae.getMessage());
        }
    }

    public double soma (String a, String b) 
    throws IllegalArgumentException {
        double soma;

        try {
            soma = Double.parseDouble(a) + Double.parseDouble(b);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(String.format("Parâmetros inválidos: %s e %s.", a, b));
        }

        if(Double.parseDouble(a) < 0){
            throw new IllegalArgumentException(String.format("Parâmetro inválido: %s", a));
        } else if(Double.parseDouble(b) < 0){
            throw new IllegalArgumentException(String.format("Parâmetro inválido: %s", b));
        } 

        return soma;
    }


}
