package com.aman.appointments.model.patientList;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aman on 08-04-2016.
 */
public class Patient implements Parcelable{

    private String name;
    private String id;
    private String age;
    private String gender;
    private String bloodGroup;
    private String city;
    private String address;
    private String emailId;
    private String profile;
    private String mobileNo;
    private String date;
    public Patient(){

    }
    protected Patient(Parcel in) {
        name = in.readString();
        id = in.readString();
        age = in.readString();
        gender = in.readString();
        bloodGroup = in.readString();
        city = in.readString();
        address = in.readString();
        emailId = in.readString();
        profile = in.readString();
        mobileNo = in.readString();
        date = in.readString();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The age
     */
    public String getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     *
     * @param bloodGroup
     * The bloodGroup
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     *
     * @param emailId
     * The emailId
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     *
     * @return
     * The profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     *
     * @param profile
     * The profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     *
     * @return
     * The mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     *
     * @param mobileNo
     * The mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(age);
        dest.writeString(gender);
        dest.writeString(bloodGroup);
        dest.writeString(city);
        dest.writeString(address);
        dest.writeString(emailId);
        dest.writeString(profile);
        dest.writeString(mobileNo);
        dest.writeString(date);
    }
}
