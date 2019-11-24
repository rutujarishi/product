package com.bool.AssetManagement.service;

import com.bool.AssetManagement.domain.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AssetManagementService {
    public Vehicle saveVehicle(Vehicle vehicle);
    public List getAllVehicles();
    public Vehicle updateVehicle(Vehicle vehicle);
    public boolean deleteVehicle(int no);
    public String getStatusOfVehicle(int no);
    public String getBatteryOfVehicle(int no);
    public String getCommentsOnVehicle(int no);
    public String getUsername(int rideCount,int no);
    public String getRideCount(int no);
    public String getInitMeterReading(int rideCount,int no);
    public String getFinalMeterReading(int rideCount, int no);
    public String getInitTime(int rideCount, int no);
    public String getDropTime(int rideCount, int no);
//    public void KafkaCons(Vehicle vehicle);
    public String getStation(int rideCount, int no);

}
