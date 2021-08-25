package dio.innovation.accessPointAPI.dto;

import dio.innovation.accessPointAPI.model.AccessLevelModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private Long id;

    @NotNull
    private AccessLevelModel accessLevel;

    private String description;

}
