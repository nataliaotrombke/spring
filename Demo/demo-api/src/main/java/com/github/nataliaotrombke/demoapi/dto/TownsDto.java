package com.github.nataliaotrombke.demoapi.dto;

public class TownsDto {
    private int VoivodeshipsId;
    private String townsName;
    private int townsId;

    public TownsDto(int voivodeshipsId, String townsName, int townsId) {
        VoivodeshipsId = voivodeshipsId;
        this.townsName = townsName;
        this.townsId = townsId;
    }

    public int getVoivodeshipsId() {
        return VoivodeshipsId;
    }

    public void setVoivodeshipsId(int voivodeshipsId) {
        VoivodeshipsId = voivodeshipsId;
    }

    public String getTownsName() {
        return townsName;
    }

    public void setTownsName(String townsName) {
        this.townsName = townsName;
    }

    public int getTownsId() {
        return townsId;
    }

    public void setTownsId(int townsId) {
        this.townsId = townsId;
    }
}
