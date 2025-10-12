package nl.techiteasy.techiteasy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CIModuleInputDto {

    @NotBlank
    @Size(min=3, max=128)
    public String name;

    @NotBlank
    @Size(min=3, max=128)
    public String type;

    @NotNull
    @Positive
    public Double price;
}
