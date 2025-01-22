package com.github.nataliaotrombke.demoapi.dto;

public class ImmovableMonumentsDto {
    private int monumentsId;
    private int townsId;
    private String monumentsName;
    private String architecturalStyle;
    private String streetName;
    private int buildingNumber;

    public ImmovableMonumentsDto(int monumentsId, int townsId, String monumentsName, String architecturalStyle, String streetName, int buildingNumber) {
        this.monumentsId = monumentsId;
        this.townsId = townsId;
        this.monumentsName = monumentsName;
        this.architecturalStyle = architecturalStyle;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
    }

    public ImmovableMonumentsDto() {

    }

    public int getMonumentsId() {
        return monumentsId;
    }

    public void setMonumentsId(int monumentsId) {
        this.monumentsId = monumentsId;
    }

    public int getTownsId() {
        return townsId;
    }

    public void setTownsId(int townsId) {
        this.townsId = townsId;
    }

    public String getMonumentsName() {
        return monumentsName;
    }

    public void setMonumentsName(String monumentsName) {
        this.monumentsName = monumentsName;
    }

    public String getArchitecturalStyle() {
        return architecturalStyle;
    }

    public void setArchitecturalStyle(String architecturalStyle) {
        this.architecturalStyle = architecturalStyle;
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
}
