package com.business.model;

/**
 * Created by User on 24/09/2015.
 */
public class AgencyProcess extends PersonalProcess {
    protected String address;
    protected String branch;
    protected String agency;
    protected String ImgUrl;

    public AgencyProcess() {
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
