package com.github.nataliaotrombke.demoapi.dto;

public class HistoricalMonumentsDto {
    private int monumentsId;
    private String monumentsName;
    private String typeOfHistoricalMonument;
    private String dateOfEntry;
    private String streetName;
    private int buildingNumber;
    private int townsId;

    public HistoricalMonumentsDto(int monumentsId, String monumentsName, String typeOfHistoricalMonument, String dateOfEntry, String streetName, int buildingNumber, int townsId) {
        this.monumentsId = monumentsId;
        this.monumentsName = monumentsName;
        this.typeOfHistoricalMonument = typeOfHistoricalMonument;
        this.dateOfEntry = dateOfEntry;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.townsId = townsId;
    }
    public HistoricalMonumentsDto(){
    }

    public int getMonumentsId() {
        return monumentsId;
    }

    public void setMonumentsId(int monumentsId) {
        this.monumentsId = monumentsId;
    }

    public String getMonumentsName() {
        return monumentsName;
    }

    public void setMonumentsName(String monumentsName) {
        this.monumentsName = monumentsName;
    }

    public String getTypeOfHistoricalMonument() {
        return typeOfHistoricalMonument;
    }

    public void setTypeOfHistoricalMonument(String typeOfHistoricalMonument) {
        this.typeOfHistoricalMonument = typeOfHistoricalMonument;
    }

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getTownsId() {
        return townsId;
    }

    public void setTownsId(int townsId) {
        this.townsId = townsId;
    }
}
