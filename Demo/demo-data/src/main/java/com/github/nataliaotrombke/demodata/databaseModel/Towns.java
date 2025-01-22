package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.*;

@Entity(name = "Towns")
public class Towns {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int townsId;
@ManyToOne
@JoinColumn(name = "voivodeships_id")
  private Voivodeships voivodeships;
  private String townsName;

  public Towns() {}

  public Towns(int townsId, String townsName, Voivodeships voivodeships) {
    this.townsId = townsId;
    this.townsName = townsName;
    this.voivodeships = voivodeships;
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

  public Voivodeships getVoivodeships() {
    return voivodeships;
  }

  public void setVoivodeships(Voivodeships voivodeships) {
    this.voivodeships = voivodeships;
  }
}