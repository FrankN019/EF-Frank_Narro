package pe.edu.i202220098.ef_jpa_data_narro_frank.service;


import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDetailDto;
import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(Integer id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(Integer id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
