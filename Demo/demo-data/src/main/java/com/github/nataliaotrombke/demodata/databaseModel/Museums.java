package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.*;

@Entity
@Table(name = "museums", schema = "data")
public class Museums {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int museumsId;
  @ManyToOne
  @JoinColumn(name = "towns_id")
  private Towns town;
  private String museumsName;
  private String streetName;
  private int buildingNumber;

  public Museums() {
  }

  public Museums(int museumsId, String museumsName, String streetName, int buildingNumber, Towns town) {
    this.museumsId = museumsId;
    this.museumsName = museumsName;
    this.streetName = streetName;
    this.buildingNumber = buildingNumber;
    this.town = town;
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

    public Towns getTown() {
        return town;
    }

    public void setTown(Towns town) {
        this.town = town;
    }
}