package com.business.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 25/09/2015.
 */
public class EndUser extends Person implements Parcelable {
    private String Address;
    private String ContactNumber;
    private String EmailAddress;
    private char[] Username;
    private char[] Password;
    private String ProfilePic;
    private String AccountStatus;


    public EndUser() {
    }

    protected EndUser(Parcel in) {
        Address = in.readString();
        ContactNumber = in.readString();
        EmailAddress = in.readString();
        Username = in.createCharArray();
        Password = in.createCharArray();
        ProfilePic = in.readString();
        AccountStatus = in.readString();
    }

    public static final Creator<EndUser> CREATOR = new Creator<EndUser>() {
        @Override
        public EndUser createFromParcel(Parcel in) {
            return new EndUser(in);
        }

        @Override
        public EndUser[] newArray(int size) {
            return new EndUser[size];
        }
    };

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public char[] getUsername() {
        return Username;
    }

    public void setUsername(char[] username) {
        Username = username;
    }

    public char[] getPassword() {
        return Password;
    }

    public void setPassword(char[] password) {
        Password = password;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        AccountStatus = accountStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Address);
        dest.writeString(ContactNumber);
        dest.writeString(EmailAddress);
        dest.writeCharArray(Username);
        dest.writeCharArray(Password);
        dest.writeString(ProfilePic);
        dest.writeString(AccountStatus);
    }
}
