package nl.techiteasy.techiteasy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class WallBracketInputDto {

    @NotBlank
    @Size(min=3, max=128)
    public String size;

    @NotNull
    public Boolean adjustable;

    @NotBlank
    @Size(min=3, max=128)
    public String name;

    @NotNull
    @Positive
    public Double price;

    public @NotBlank @Size(min = 3, max = 128) String getSize() {
        return size;
    }

    public @NotNull Boolean getAdjustable() {
        return adjustable;
    }

    public @NotBlank @Size(min = 3, max = 128) String getName() {
        return name;
    }

    public @NotNull @Positive Double getPrice() {
        return price;
    }
}
