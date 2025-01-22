package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.*;

@Entity
@Table(name = "immovable_monuments", schema = "data")
public class ImmovableMonuments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int monumentsId;
  private int townsId;
  private String monumentsName;
  private String architecturalStyle;
  private String streetName;
  private int buildingNumber;

  public ImmovableMonuments(int monumentsId, String monumentsName, String architecturalStyle, String streetName, int buildingNumber, int townsId) {
    this.monumentsId = monumentsId;
    this.monumentsName = monumentsName;
    this.architecturalStyle = architecturalStyle;
    this.streetName = streetName;
    this.buildingNumber = buildingNumber;
    this.townsId = townsId;
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

  public int getTownsId() {
    return townsId;
  }

  public void setTownsId(int townsId) {
    this.townsId = townsId;
  }

  public void setTowns(Towns townToUse) {
  }
}