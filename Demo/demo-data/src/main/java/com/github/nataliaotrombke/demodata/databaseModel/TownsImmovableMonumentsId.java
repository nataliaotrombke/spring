package com.github.nataliaotrombke.demodata.databaseModel;

import java.io.Serializable;
import java.util.Objects;

public class TownsImmovableMonumentsId implements Serializable {
    private int townsId;
    private int monumentsId;

    public TownsImmovableMonumentsId() {
    }

    public TownsImmovableMonumentsId(int townsId, int monumentsId) {
        this.townsId = townsId;
        this.monumentsId = monumentsId;
    }
//
//    public int getTownsId() {
//        return townsId;
//    }
//
//    public void setTownsId(int townsId) {
//        this.townsId = townsId;
//    }
//
//    public int getMonumentsId() {
//        return monumentsId;
//    }
//
//    public void setMonumentsId(int monumentsId) {
//        this.monumentsId = monumentsId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownsImmovableMonumentsId that = (TownsImmovableMonumentsId) o;
        return townsId == that.townsId && monumentsId == that.monumentsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(townsId, monumentsId);
    }
}