package com.adote.me.dtl.vaccine;

import javax.validation.constraints.NotEmpty;

public class VaccineInputDTO {

    @NotEmpty(message = "Nome da vacina não pode ser vazio")
    private String name;

    @NotEmpty(message = "Data da vacina não pode ser vazia")
    private String date;

    @NotEmpty(message = "Validade da vacina não pode ser vazia")
    private String validity;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getValidity() {
        return validity;
    }

    public void validateVaccine() throws Exception {
        if (name.equals("") && (!date.isEmpty() || !validity.isEmpty()))
            throw new Exception(getClass().getDeclaredField("name").getAnnotation(NotEmpty.class).message());

        if (!name.equals("") && date.isEmpty())
            throw new Exception(getClass().getDeclaredField("date").getAnnotation(NotEmpty.class).message());

        if (!name.equals("") && validity.isEmpty())
            throw new Exception(getClass().getDeclaredField("validity").getAnnotation(NotEmpty.class).message());

    }
}
