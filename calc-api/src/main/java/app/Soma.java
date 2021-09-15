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

            if(Double.parseDouble(a) < 0){
                throw new BadRequestException(String.format("Carectere inválido: %s", a));
            } else if(Double.parseDouble(b) < 0){
                throw new BadRequestException(String.format("Caractere inválido: %s", b));
            } 

            throw new BadRequestException(String.format("Caractere inválido: %s e %s.", a, b));


        }
    }

