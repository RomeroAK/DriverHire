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

    @PutMapping(path = "{driverId}")
    public void updateDriverDetails(@PathVariable("driverId") Long ID, @RequestParam(required = false) String fName, @RequestParam(required = false) String lName, @RequestParam(required = false) String Idnumber)
    {
        driverService.updateDriver(ID, fName, lName, Idnumber);

    }

    @GetMapping
    public List<Driver> getDrivers(Driver driver)
    {
        return driverService.getDrivers(driver.ID);
    }

    @DeleteMapping
    public void deleteDriver(Driver driver)
    {
        driverService.deleteDriver(driver.Idnumber);
    }

    @GetMapping(path = "{experience}")
    public ResponseEntity<Optional<Driver>> selectDriverByExperience(@RequestParam int experience) {
        Optional<Driver> drivers = driverService.getDriverbyExperience(experience);
        return ResponseEntity.ok(drivers);
    }
}
