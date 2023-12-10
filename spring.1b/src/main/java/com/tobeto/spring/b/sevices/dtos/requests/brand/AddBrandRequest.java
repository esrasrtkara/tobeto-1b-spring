package com.tobeto.spring.b.sevices.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    @NotBlank(message = "Marka adı boş olamaz")
   // @Length(min = 3, max = 20)
    @Size(min = 3, max = 20,message = "Marka 3 il2 20 hane arasında olmalıdır")
    private String name;
}
