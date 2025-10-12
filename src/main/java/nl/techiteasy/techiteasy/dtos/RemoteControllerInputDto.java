package nl.techiteasy.techiteasy.dtos;

import jakarta.validation.constraints.*;

public class RemoteControllerInputDto {

    @NotBlank
    public String compatibleWith;

    @NotBlank
    public String batteryType;

    @NotBlank
    @Size(min=3, max=128)
    public String name;

    @NotBlank
    @Size(min=3, max=128)
    public String brand;

    @NotNull
    @Positive
    public Double price;

    @NotNull
    @PositiveOrZero
    public Integer originalStock;
}
