package com.business.model;

/**
 * Created by User on 24/09/2015.
 */
public abstract class BaseModel {
    protected String Name;
    protected String Id;
    protected String Sub_Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSub_Id() {
        return Sub_Id;
    }

    public void setSub_Id(String sub_Id) {
        Sub_Id = sub_Id;
    }


}
