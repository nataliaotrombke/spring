package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Towns")
public class Towns {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int townsId;
  private String townsName;

  public Towns(int townsId, String townsName) {
    this.townsId = townsId;
    this.townsName = townsName;
  }

  public Towns() {
  }

  public int getTownsId() {
    return townsId;
  }

  public void setTownsId(int townsId) {
    this.townsId = townsId;
  }

  public String getTownsName() {
    return townsName;
  }

  public void setTownsName(String townsName) {
    this.townsName = townsName;
  }
}
