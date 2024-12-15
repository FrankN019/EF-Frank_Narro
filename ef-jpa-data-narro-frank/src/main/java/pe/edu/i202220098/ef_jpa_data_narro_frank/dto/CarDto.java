package pe.edu.i202220098.ef_jpa_data_narro_frank.dto;

public record CarDto(
        Integer carId,
        String make,
        String model,
        int year,
        String vin,
        String licensePlate,
        int mileage,
        String color,
        String engineType,
        String ownerName
) {}
