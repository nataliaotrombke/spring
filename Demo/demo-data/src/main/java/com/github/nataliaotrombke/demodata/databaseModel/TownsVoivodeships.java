package com.github.nataliaotrombke.demodata.databaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity(name = "TownsVoivodeships")
@IdClass(TownsVoivodeshipsId.class)
public class TownsVoivodeships {
  @Id
  private int townsId;

  @Id
  private int voivodeshipsId;

  public TownsVoivodeships() {
  }

  public TownsVoivodeships(int townsId, int voivodeshipsId) {
    this.townsId = townsId;
    this.voivodeshipsId = voivodeshipsId;
  }

  public int getTownsId() {
    return townsId;
  }

  public void setTownsId(int townsId) {
    this.townsId = townsId;
  }

  public int getVoivodeshipsId() {
    return voivodeshipsId;
  }

  public void setVoivodeshipsId(int voivodeshipsId) {
    this.voivodeshipsId = voivodeshipsId;
  }
}