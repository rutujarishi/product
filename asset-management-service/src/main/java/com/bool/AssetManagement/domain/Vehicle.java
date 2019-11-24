package com.bool.AssetManagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Vehicle {

     @Id
     int no;
     int regno;
     int charge;
     String username;
     int initMeterReading;
     int finalMeterReading;
     int rideCount;
     Date initTime;
     Date dropTime;
     int totalDistance;
     String feedbackOrComments;
     String status;
     String station;

}
