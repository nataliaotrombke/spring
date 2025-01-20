package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Voivodeships")
public class Voivodeships {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int voivodeshipsId;
  private String voivodeshipsName;

  public Voivodeships(int voivodeshipsId, String voivodeshipsName) {
    this.voivodeshipsId = voivodeshipsId;
    this.voivodeshipsName = voivodeshipsName;
  }

  public Voivodeships() {
  }

  public int getVoivodeshipsId() {
    return voivodeshipsId;
  }

  public void setVoivodeshipsId(int voivodeshipsId) {
    this.voivodeshipsId = voivodeshipsId;
  }

  public String getVoivodeshipsName() {
    return voivodeshipsName;
  }

  public void setVoivodeshipsName(String voivodeshipsName) {
    this.voivodeshipsName = voivodeshipsName;
  }
}
