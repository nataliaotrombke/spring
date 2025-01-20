package com.github.nataliaotrombke.demodata.databaseModel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "historicalMonuments")
public class HistoricalMonuments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer monumentsId;
  private String monumentsName;
  private String typeOfHistoricalMonument;
  private String dateOfEntry;
  private String streetName;
  private Integer buildingNumber;

  public HistoricalMonuments(int monumentsId, String monumentsName, String typeOfHistoricalMonument, String dateOfEntry, String zipCode, String streetName, int buildingNumber) {
    this.monumentsId = monumentsId;
    this.monumentsName = monumentsName;
    this.typeOfHistoricalMonument = typeOfHistoricalMonument;
    this.dateOfEntry = dateOfEntry;
    this.streetName = streetName;
    this.buildingNumber = buildingNumber;
  }

  public HistoricalMonuments() {
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

}
