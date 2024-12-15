package pe.edu.i202220098.ef_jpa_data_narro_frank.response;

import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {

}
