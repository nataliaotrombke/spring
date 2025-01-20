package com.github.nataliaotrombke.demodata.databaseModel;

import java.io.Serializable;
import java.util.Objects;

public class TownsHistoricalMonumentsId implements Serializable {
    private int townsId;
    private int monumentsId;

    public TownsHistoricalMonumentsId() {
    }

    public TownsHistoricalMonumentsId(int townsId, int monumentsId) {
        this.townsId = townsId;
        this.monumentsId = monumentsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownsHistoricalMonumentsId that = (TownsHistoricalMonumentsId) o;
        return townsId == that.townsId && monumentsId == that.monumentsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(townsId, monumentsId);
    }
}