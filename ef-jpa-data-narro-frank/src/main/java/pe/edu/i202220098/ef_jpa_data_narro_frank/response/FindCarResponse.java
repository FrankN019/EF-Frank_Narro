package pe.edu.i202220098.ef_jpa_data_narro_frank.response;

import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto car) {
}
