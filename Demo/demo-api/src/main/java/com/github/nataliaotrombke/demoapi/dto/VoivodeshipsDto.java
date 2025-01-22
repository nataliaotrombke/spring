package com.github.nataliaotrombke.demoapi.dto;

public class VoivodeshipsDto {
    private int voivodeshipsId;
    private String voivodeshipsName;

    public VoivodeshipsDto(int voivodeshipsId, String voivodeshipsName) {
        this.voivodeshipsId = voivodeshipsId;
        this.voivodeshipsName = voivodeshipsName;
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
