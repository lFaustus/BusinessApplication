package com.business.model;

/**
 * Created by User on 25/09/2015.
 */
public class ProcessManagerModel extends AgencyProcess {

    private String Recurrence;
    private String Number_Recurrence;
    private String DateCreated;
    private String DateModified;

    public String getNumber_Recurrence() {
        return Number_Recurrence;
    }

    public void setNumber_Recurrence(String number_Recurrence) {
        Number_Recurrence = number_Recurrence;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public String getRecurrence() {
        return Recurrence;
    }

    public void setRecurrence(String recurrence) {
        Recurrence = recurrence;
    }

    public String getDateModified() {
        return DateModified;
    }

    public void setDateModified(String dateModified) {
        DateModified = dateModified;
    }
}
