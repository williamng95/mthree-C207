package com.sg.intermediate.carlot.dto;

public class CarKey {
    private String VIN;
    private boolean laserCut;

    // plus getters, setters & appropriate constructors

    /**
     * @param vIN
     * @param laserCut
     */
    public CarKey(String vIN, boolean laserCut) {
        VIN = vIN;
        this.laserCut = laserCut;
    }

    /**
     * @return the vIN
     */
    public String getVIN() {
        return VIN;
    }

    /**
     * @param vIN the vIN to set
     */
    public void setVIN(String vIN) {
        VIN = vIN;
    }

    /**
     * @return the laserCut
     */
    public boolean isLaserCut() {
        return laserCut;
    }

    /**
     * @param laserCut the laserCut to set
     */
    public void setLaserCut(boolean laserCut) {
        this.laserCut = laserCut;
    }

}
