package com.github.nataliaotrombke.demoapi.dto;


public class MuseumsDto {
  private int museumsId;
  private int townsId;
  private String museumsName;
  private String streetName;
  private int buildingNumber;

  public MuseumsDto(int museumsId, int townsId, String museumsName, String streetName, int buildingNumber) {
    this.museumsId = museumsId;
    this.townsId = townsId;
    this.museumsName = museumsName;
    this.streetName = streetName;
    this.buildingNumber = buildingNumber;
  }

  public MuseumsDto() {
  }

  public int getMuseumsId() {
    return museumsId;
  }

  public void setMuseumsId(int museumsId) {
    this.museumsId = museumsId;
  }

  public int getTownsId() {
    return townsId;
  }

  public void setTownsId(int townsId) {
    this.townsId = townsId;
  }

  public String getMuseumsName() {
    return museumsName;
  }

  public void setMuseumsName(String museumsName) {
    this.museumsName = museumsName;
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