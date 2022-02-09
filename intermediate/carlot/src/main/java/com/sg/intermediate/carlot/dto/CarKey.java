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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((VIN == null) ? 0 : VIN.hashCode());
        result = prime * result + (laserCut ? 1231 : 1237);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarKey other = (CarKey) obj;
        if (VIN == null) {
            if (other.VIN != null)
                return false;
        } else if (!VIN.equals(other.VIN))
            return false;
        if (laserCut != other.laserCut)
            return false;
        return true;
    }

    // hashcode and equals

}
