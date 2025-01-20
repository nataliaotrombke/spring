package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "immovableMonuments")
public class ImmovableMonuments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int monumentsId;
  private String monumentsName;
  private String architecturalStyle;
  private String streetName;
  private int buildingNumber;

  public ImmovableMonuments(int monumentsId, String monumentsName, String architecturalStyle, String zipCode, String streetName, int buildingNumber) {
    this.monumentsId = monumentsId;
    this.monumentsName = monumentsName;
    this.architecturalStyle = architecturalStyle;
    this.streetName = streetName;
    this.buildingNumber = buildingNumber;
  }

  public ImmovableMonuments() {
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
