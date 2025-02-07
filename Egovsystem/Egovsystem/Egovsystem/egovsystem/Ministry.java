package com.mycompany.egovsystem;

import java.util.ArrayList;

/**
 * Class representing a Ministry with basic details.
 *
 * @author yoka2
 */
public class Ministry {

    private String ministryName;
    private String ministerName;

    // Constructor
    public Ministry(String ministryName, String ministerName) {
        this.ministryName = ministryName;
        this.ministerName = ministerName;
    }

    // Getters and Setters

    /**
     * Gets the name of the ministry.
     *
     * @return the name of the ministry
     */
    public String getMinistryName() {
        return ministryName;
    }

    /**
     * Sets the name of the ministry.
     *
     * @param ministryName the new name of the ministry
     */
    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName;
    }

    /**
     * Gets the name of the minister.
     *
     * @return the name of the minister
     */
    public String getMinisterName() {
        return ministerName;
    }

    /**
     * Sets the name of the minister.
     *
     * @param ministerName the new name of the minister
     */
    public void setMinisterName(String ministerName) {
        this.ministerName = ministerName;
    }

    public void displayministryname ( ){
        System.out.println(this.ministryName);
    }
}

