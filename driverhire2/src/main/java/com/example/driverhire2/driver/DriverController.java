package com.example.driverhire2.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/drivers")
public class DriverController {

    private final DriverService driverService;


    @Autowired DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public void addDriver(@RequestBody Driver driver)
    {
        driverService.createDriver(driver);
    }

    @DeleteMapping(path = "idNumber/{idNumber}")
    public void updateDriverDetails(@PathVariable("idNumber") String idNumber, @RequestParam(required = false) String fName, @RequestParam(required = false) String lName, @RequestParam(required = false) Long ID)
    {
        driverService.updateDriver(ID, fName, lName, idNumber);

    }

    @GetMapping
    public List<Driver> getDrivers(Driver driver)
    {
        return driverService.getDrivers(driver.ID);
    }

    @DeleteMapping(path = "Idnumber/{Idnumber}")
    public void deleteDriver(@PathVariable ("Idnumber") String Idnumber)
    {
        driverService.deleteDriver(Idnumber);
    }

    @GetMapping(path = "experience/{experience}")
    public ResponseEntity<Optional<Driver>> selectDriverByExperience(@RequestParam int experience) {
        Optional<Driver> drivers = driverService.getByExperience(experience);
        return ResponseEntity.ok(drivers);
    }

    @GetMapping(path = "experienceTest/{experience}")
    public List<Driver> getByExp(@RequestParam int exp) {
        List<Driver> listByExp = driverService.getByExp(exp);

        return listByExp;
    }

    @GetMapping(path = "license/{licenseType}")
    public Optional<Driver> getByLicenseType (@RequestParam String licenseType){

        Optional<Driver> listByLicense = driverService.getByLicenseType(licenseType);

        return listByLicense;
    }
}
