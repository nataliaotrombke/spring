package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.*;

@Entity
@Table(name = "historical_monuments", schema = "data")
public class HistoricalMonuments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int monumentsId;
  @ManyToOne
  @JoinColumn(name = "towns_id")
  private Towns towns;
  private String monumentsName;
  private String typeOfHistoricalMonument;
  private String dateOfEntry;
  private String streetName;
  private int buildingNumber;

  public HistoricalMonuments(int monumentsId, Towns towns, String monumentsName, String typeOfHistoricalMonument, String dateOfEntry, String streetName, int buildingNumber) {
    this.monumentsId = monumentsId;
    this.towns = towns;
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

  public Towns getTowns() {
    return towns;
  }

  public void setTowns(Towns towns) {
    this.towns = towns;
  }

}