package org.billingservice.Model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by sony on 16-09-2017.
 */
@Data
@Entity
@Table(name = "RIF")
@NoArgsConstructor
@Builder
public class RestaurantDetails implements Serializable {

    @Column(name = "ResID", nullable = false)
    private String resID;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Number",nullable = false)
    private int number;


    @Column(name = "Address",nullable = false)
    private String address;

    @Column(name = "EmailID",nullable = false)
    private String emailAddress;


    public String getResID() {
        return resID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
