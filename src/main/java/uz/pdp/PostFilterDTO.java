package uz.pdp;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ParameterObject
public class PostFilterDTO {

    @Parameter(example = "10")
    @Min(1)
    private Integer userId;

    private String title;

    @Parameter(example = "2026-09-27T13:00:00")
    private LocalDateTime createdFrom;


    private LocalDateTime createdTo;


}
