package org.indychkov.angulartoys.model;

public class Toy {
    private String toyName;
    private String toySize;
    private String toyDescription;
    private Long toyID;

        public Toy() {
    }
    public Toy(ToyForm toyForm){
        this.toyID=toyForm.getToyID();
        this.toyName=toyForm.getToyName();
        this.toySize=toyForm.getToySize();
        this.toyDescription=toyForm.getToyDescription();
    }
    public Toy(Long toyID, String toyName, String toySize, String toyDescription) {
        this.toyName = toyName;
        this.toySize = toySize;
        this.toyDescription = toyDescription;
        this.toyID=toyID;
    }

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
