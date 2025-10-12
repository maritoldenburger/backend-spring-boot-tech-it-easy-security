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

    public @NotBlank String getCompatibleWith() {
        return compatibleWith;
    }

    public @NotBlank String getBatteryType() {
        return batteryType;
    }

    public @NotBlank @Size(min = 3, max = 128) String getName() {
        return name;
    }

    public @NotBlank @Size(min = 3, max = 128) String getBrand() {
        return brand;
    }

    public @NotNull @Positive Double getPrice() {
        return price;
    }

    public @NotNull @PositiveOrZero Integer getOriginalStock() {
        return originalStock;
    }
}
