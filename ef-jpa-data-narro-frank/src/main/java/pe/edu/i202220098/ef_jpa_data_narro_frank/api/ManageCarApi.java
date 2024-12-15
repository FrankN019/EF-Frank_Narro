package pe.edu.i202220098.ef_jpa_data_narro_frank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDetailDto;
import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDto;
import pe.edu.i202220098.ef_jpa_data_narro_frank.response.*;
import pe.edu.i202220098.ef_jpa_data_narro_frank.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars() {
        try {
            List<CarDto> cars = manageService.getAllCars();
            if (!cars.isEmpty())
                return new FindCarsResponse("01", null, cars);
            else
                return new FindCarsResponse("02", "No se encontraron coches", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Ocurrió un error, por favor intente nuevamente", null);
        }
    }

    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        try {
            Optional<CarDetailDto> optional = manageService.getCarById(id);
            return optional.map(car ->
                    new FindCarResponse("01", null, car)
            ).orElse(
                    new FindCarResponse("02", "No se encontraron coches", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "Ocurrió un error, por favor intente nuevamente", null);
        }
    }

    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {
        try {
            if (manageService.updateCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "No se encontraron coches");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "Ocurrió un error, por favor intente nuevamente");
        }
    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable Integer id) {
        try {
            if (manageService.deleteCarById(id))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "No se encontraron coches");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "Ocurrió un error, por favor intente nuevamente");
        }
    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarDetailDto carDetailDto) {
        try {
            if (manageService.addCar(carDetailDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "El coche ya existe");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Ocurrió un error, por favor intente nuevamente");
        }
    }
}
