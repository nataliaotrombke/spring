package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity(name = "TownsImmovableMonuments")
@IdClass(TownsImmovableMonumentsId.class)
public class TownsImmovableMonuments {
  @Id
  private int townsId;

  @Id
  private int monumentsId;

  public TownsImmovableMonuments() {
  }

  public TownsImmovableMonuments(int townsId, int monumentsId) {
    this.townsId = townsId;
    this.monumentsId = monumentsId;
  }

  public int getTownsId() {
    return townsId;
  }

  public void setTownsId(int townsId) {
    this.townsId = townsId;
  }

  public int getMonumentsId() {
    return monumentsId;
  }

  public void setMonumentsId(int monumentsId) {
    this.monumentsId = monumentsId;
  }
}