package com.example.mcs_uts;

import android.widget.Button;

public class Schedule {

    String rLetter, scheduleDate, scheduleCountry, scheduleCity, price;
    int scheduleImageFlag, scheduleImageCircuit;

    public Schedule(String rLetter, String scheduleDate, String scheduleCountry, String scheduleCity, String price,int scheduleImageCircuit, int scheduleImageFlag) {
        this.rLetter = rLetter;
        this.scheduleDate = scheduleDate;
        this.scheduleCountry = scheduleCountry;
        this.scheduleCity = scheduleCity;
        this.price = price;
        this.scheduleImageFlag = scheduleImageFlag;
        this.scheduleImageCircuit = scheduleImageCircuit;
    }

    public String getPrice() {
        return price;
    }

    public int getScheduleImageCircuit() {
        return scheduleImageCircuit;
    }

    public void setScheduleImageCircuit(int scheduleImageCircuit) {
        this.scheduleImageCircuit = scheduleImageCircuit;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getrLetter() {
        return rLetter;
    }

    public void setrLetter(String rLetter) {
        this.rLetter = rLetter;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleCountry() {
        return scheduleCountry;
    }

    public void setScheduleCountry(String scheduleCountry) {
        this.scheduleCountry = scheduleCountry;
    }

    public String getScheduleCity() {
        return scheduleCity;
    }

    public void setScheduleCity(String scheduleCity) {
        this.scheduleCity = scheduleCity;
    }

    public int getScheduleImageFlag() {
        return scheduleImageFlag;
    }

    public void setScheduleImageFlag(int scheduleImageFlag) {
        this.scheduleImageFlag = scheduleImageFlag;
    }
}
