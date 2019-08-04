package org.indychkov.angulartoys.model;

public class ToyForm {
    private String toyName;
    private String toySize;
    private String toyDescription;
    private Long toyID;
    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public String getToySize() {
        return toySize;
    }

    public void setToySize(String toySize) {
        this.toySize = toySize;
    }

    public String getToyDescription() {
        return toyDescription;
    }

    public void setToyDescription(String toyDescription) {
        this.toyDescription = toyDescription;
    }



    public Long getToyID() {
        return toyID;
    }

    public void setToyID(Long toyID) {
        this.toyID = toyID;
    }
}
