package pe.edu.i202220098.ef_jpa_data_narro_frank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDetailDto;
import pe.edu.i202220098.ef_jpa_data_narro_frank.dto.CarDto;
import pe.edu.i202220098.ef_jpa_data_narro_frank.entity.Car;
import pe.edu.i202220098.ef_jpa_data_narro_frank.repository.CarRepository;
import pe.edu.i202220098.ef_jpa_data_narro_frank.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<>();
        carRepository.findAll().forEach(car -> cars.add(new CarDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getMileage(),
                car.getColor(),
                car.getEngineType(),
                car.getOwnerName()
        )));
        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(Integer id) throws Exception {
        return carRepository.findById(id).map(car -> new CarDetailDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()
        ));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDto.carId());
        if (optional.isPresent()) {
            Car car = optional.get();
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setVin(carDto.vin());
            car.setLicensePlate(carDto.licensePlate());
            car.setMileage(carDto.mileage());
            car.setColor(carDto.color());
            car.setEngineType(carDto.engineType());
            car.setOwnerName(carDto.ownerName());
            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCarById(Integer id) throws Exception {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Car car = new Car();
        car.setMake(carDetailDto.make());
        car.setModel(carDetailDto.model());
        car.setYear(carDetailDto.year());
        car.setVin(carDetailDto.vin());
        car.setLicensePlate(carDetailDto.licensePlate());
        car.setOwnerName(carDetailDto.ownerName());
        car.setOwnerContact(carDetailDto.ownerContact());
        car.setPurchaseDate(carDetailDto.purchaseDate());
        car.setMileage(carDetailDto.mileage());
        car.setEngineType(carDetailDto.engineType());
        car.setColor(carDetailDto.color());
        car.setInsuranceCompany(carDetailDto.insuranceCompany());
        car.setInsurancePolicyNumber(carDetailDto.insurancePolicyNumber());
        car.setRegistrationExpirationDate(carDetailDto.registrationExpirationDate());
        car.setServiceDueDate(carDetailDto.serviceDueDate());
        carRepository.save(car);
        return true;
    }
}
