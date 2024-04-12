package com.example.driverhire2.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {


    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void createDriver(Driver driver)
    {
        Optional<Driver> tempDriver = driverRepository.findbyIdnumber(driver.getIDnumber());

        if(tempDriver.isPresent())
        {
            throw new IllegalStateException("ID Number already exists");
        }

        driverRepository.save(driver);
    }

    @Transactional
    public void updateDriver(Long driverId, String Idnumber, String fName, String lName)
    {
        Driver driver = driverRepository.findbyIdnumber(Idnumber)
                .orElseThrow(()-> new IllegalStateException("Driver with ID number " + Idnumber + "does not exist"));

        driver.setFirstName(fName);
        driver.setLastName(fName);
    }

    public List<Driver> getDrivers(Long driverId)
    {
        List<Driver> driver = driverRepository.findAll();

        return driver;

    }

    public void deleteDriver(String idnum)
    {
        Driver driver = driverRepository.findbyIdnumber(idnum)
                .orElseThrow(()-> new IllegalStateException("Driver with ID number " + idnum + "does not exist"));

        driverRepository.delete(driver);
    }

    public Optional<Driver> getDriverbyExperience (int exp)
    {
       return driverRepository.getByExperience(exp);
    }
}
