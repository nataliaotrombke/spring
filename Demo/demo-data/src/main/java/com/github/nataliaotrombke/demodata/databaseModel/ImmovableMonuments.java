package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.*;

@Entity
@Table(name = "immovable_monuments", schema = "data")
public class ImmovableMonuments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int monumentsId;
  @ManyToOne
  @JoinColumn(name = "towns_id")
  private Towns town;
  private String monumentsName;
  private String architecturalStyle;
  private String streetName;
  private int buildingNumber;

  public ImmovableMonuments(int monumentsId, Towns town, String monumentsName, String architecturalStyle, String streetName, int buildingNumber) {
    this.monumentsId = monumentsId;
    this.town = town;
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

  public Towns getTown() {
    return town;
  }

  public void setTown(Towns town) {
    this.town = town;
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
    return 0;
  }
}