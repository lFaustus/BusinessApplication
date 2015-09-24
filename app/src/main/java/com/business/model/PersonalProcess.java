package com.business.model;

/**
 * Created by User on 24/09/2015.
 */
public class PersonalProcess extends BaseModel {
    protected String sourceUrl;
    protected String waiting;
    protected String done;
    protected String undone;
    protected String check;
    protected String uncheck;
    protected String count;
    protected String requirementCount;

    public PersonalProcess() {
    }

    public String getRequirementCount() {
        return requirementCount;
    }

    public void setRequirementCount(String requirementCount) {
        this.requirementCount = requirementCount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getWaiting() {
        return waiting;
    }

    public void setWaiting(String waiting) {
        this.waiting = waiting;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getUndone() {
        return undone;
    }

    public void setUndone(String undone) {
        this.undone = undone;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getUncheck() {
        return uncheck;
    }

    public void setUncheck(String uncheck) {
        this.uncheck = uncheck;
    }


}
