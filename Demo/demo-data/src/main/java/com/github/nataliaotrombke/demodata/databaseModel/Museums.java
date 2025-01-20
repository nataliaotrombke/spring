package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "museums")
public class Museums {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int museumsId;
  private String museumsName;
  private String streetName;
  private int buildingNumber;
  private int townsId;

  public Museums(int museumsId, String museumsName, String zipCode, String streetName, int buildingNumber, int townsId) {
    this.museumsId = museumsId;
    this.museumsName = museumsName;
    this.streetName = streetName;
    this.buildingNumber = buildingNumber;
    this.townsId = townsId;
  }

  public Museums() {
  }

  public int getMuseumsId() {
    return museumsId;
  }

  public void setMuseumsId(int museumsId) {
    this.museumsId = museumsId;
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

  public int getTownsId() {
    return townsId;
  }

  public void setTownsId(int townsId) {
    this.townsId = townsId;
  }
}
