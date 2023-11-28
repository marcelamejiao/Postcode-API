package io.nology.postcodeAPI.suburb;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class SuburbCreateDTO {

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @NotBlank
    private String postcode;

    public SuburbCreateDTO(String name, String postcode) {
        this.name = name;
        this.postcode = postcode;
    }
}
