package com.example.driverhire2.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverService {


    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(Driver driver)
    {
        driver.setFirstName(driver.firstName);
        driver.setLastName(driver.lastName);
        driver.setGender(driver.gender);
        driver.setIdnumber(driver.Idnumber);

        return driver;
    }

    @Transactional
    public void updateDriver(Long driverId, String Idnumber, String fName, String lName)
    {
        Driver driver = driverRepository.findbyIdnumber(Idnumber)
                .orElseThrow(()-> new IllegalStateException("Driver with ID number " + Idnumber + "does not exist"));

        driver.setFirstName(fName);
        driver.setLastName(fName);
    }
}
