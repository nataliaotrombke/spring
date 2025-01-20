package com.github.nataliaotrombke.demodata.databaseModel;

import java.io.Serializable;
import java.util.Objects;

public class TownsVoivodeshipsId implements Serializable {
    private int townsId;
    private int voivodeshipsId;

    public TownsVoivodeshipsId() {
    }

    public TownsVoivodeshipsId(int townsId, int voivodeshipsId) {
        this.townsId = townsId;
        this.voivodeshipsId = voivodeshipsId;
    }

//    public int getTownsId() {
//        return townsId;
//    }
//
//    public void setTownsId(int townsId) {
//        this.townsId = townsId;
//    }
//
//    public int getVoivodeshipsId() {
//        return voivodeshipsId;
//    }
//
//    public void setVoivodeshipsId(int voivodeshipsId) {
//        this.voivodeshipsId = voivodeshipsId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownsVoivodeshipsId that = (TownsVoivodeshipsId) o;
        return townsId == that.townsId && voivodeshipsId == that.voivodeshipsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(townsId, voivodeshipsId);
    }
}