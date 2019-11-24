package com.bool.AssetManagement.controller;

import com.bool.AssetManagement.domain.Vehicle;
import com.bool.AssetManagement.service.AssetManagementService;
import com.bool.AssetManagement.service.AssetManagementServieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Component
@RequestMapping(value = "api/v1")
public class AssetController {
    private AssetManagementService assetManagementService;
    @Autowired
    public AssetController(AssetManagementService  assetManagementService){
        this.assetManagementService = assetManagementService;
    }


    @PostMapping("asset")
    public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle){
        ResponseEntity responseEntity;
        assetManagementService.saveVehicle(vehicle);
        responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("asset")
    public ResponseEntity<?> getAllVehicles(){
        return new ResponseEntity<List<Vehicle>>(assetManagementService.getAllVehicles(),HttpStatus.OK);

    }

    @PutMapping("assetUpdate")
    public  ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle){
       ResponseEntity responseEntity;
       assetManagementService.saveVehicle(assetManagementService.updateVehicle(vehicle));
       return new ResponseEntity<String>("successfully updated",HttpStatus.OK);
    }

    @DeleteMapping("assetUpdate/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") int no){
    ResponseEntity responseEntity;
    assetManagementService.deleteVehicle(no);
    return new ResponseEntity<>(assetManagementService.getAllVehicles(),HttpStatus.OK);
    }

    @GetMapping("status/{id}")
    public ResponseEntity<?> getStatusOfVehicle(@PathVariable("id") int no){
        ResponseEntity responseEntity;
        return new ResponseEntity<String>(assetManagementService.getStatusOfVehicle(no),HttpStatus.OK);
    }

    @GetMapping("battery/{id}")
    public ResponseEntity<?> getBatteryOfVehicle(@PathVariable("id") int no){
        ResponseEntity responseEntity;
        return new ResponseEntity<String>(assetManagementService.getBatteryOfVehicle(no),HttpStatus.OK);
    }

    @GetMapping("comments/{id}")
    public ResponseEntity<?> getCommentsOnVehicle(@PathVariable("id") int no){
        ResponseEntity responseEntity;
        return new ResponseEntity<String>(assetManagementService.getCommentsOnVehicle(no),HttpStatus.OK);
    }

    @GetMapping("count/{id}")
    public ResponseEntity<?> getRideCountOfVehicle(@PathVariable("id") int no){
        ResponseEntity responseEntity;
        return new ResponseEntity<>(assetManagementService.getRideCount(no),HttpStatus.OK);
    }

    @GetMapping("user/{id1}/{id2}")
    public ResponseEntity<?> getUsername(@PathVariable("id1") int no,@PathVariable("id2") int rideCount){
        ResponseEntity responseEntity;
        return new ResponseEntity<>(assetManagementService.getUsername(rideCount,no),HttpStatus.OK);
    }

    @GetMapping("ReadingInit/{id1}/{id2}")
    public ResponseEntity<?> getInitMeterReading(@PathVariable("id1") int no,@PathVariable("id2") int rideCount){
        ResponseEntity responseEntity;
        return new ResponseEntity<>(assetManagementService.getInitMeterReading(rideCount,no),HttpStatus.OK);
    }

    @GetMapping("ReadingDrop/{id1}/{id2}")
    public ResponseEntity<?> getFinalMeterReading(@PathVariable("id1") int no,@PathVariable("id2") int rideCount){
        ResponseEntity responseEntity;
        return new ResponseEntity<>(assetManagementService.getFinalMeterReading(rideCount,no),HttpStatus.OK);
    }


    @GetMapping("TimeInit/{id1}/{id2}")
    public ResponseEntity<?> getInitTime(@PathVariable("id1") int no,@PathVariable("id2") int rideCount){
        ResponseEntity responseEntity;
        return new ResponseEntity<>(assetManagementService.getInitTime(rideCount,no),HttpStatus.OK);
    }

    @GetMapping("TimeDrop/{id1}/{id2}")
    public ResponseEntity<?> getDropTime(@PathVariable("id1") int no,@PathVariable("id2") int rideCount){
        ResponseEntity responseEntity;
        return new ResponseEntity<>(assetManagementService.getDropTime(rideCount,no),HttpStatus.OK);
    }

    @GetMapping("station/{id1}/{id2}")
    public ResponseEntity<?> getStation(@PathVariable("id1") int no,@PathVariable("id2") int rideCount){
        ResponseEntity responseEntity;
        return new ResponseEntity<>(assetManagementService.getStation(rideCount,no),HttpStatus.OK);
    }

//    @Autowired
//    KafkaTemplate<String, Vehicle> KafkaJsontemplate;
//
//    String TOPIC_NAME = "test";

//    @PostMapping(value = "/postItem",consumes = {"application/json"},produces = {"application/json"})
//    public ResponseEntity<String> postJsonMessage(@RequestBody Vehicle vehicle){
//        KafkaJsontemplate.send(TOPIC_NAME,vehicle);
//        return new ResponseEntity<>("produced",HttpStatus.OK);
//    }
}
