package com.example.driverhire2.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public void addDriver(@RequestBody Driver driver)
    {
        driverService.createDriver(driver);
    }

    @PutMapping
    public void updateDriverDetails(@PathVariable("driverId") Long ID, @RequestParam(required = false) String fName, @RequestParam(required = false) String lName, @RequestParam(required = false) String Idnumber)
    {
        driverService.updateDriver(ID, fName, lName, Idnumber);

    }
}
