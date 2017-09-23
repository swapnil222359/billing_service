package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by sony on 19-09-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "trid",nullable = false,unique = true)
    private int trID;

    @Column(name = "total" ,nullable = false)
    private double total;

    @Column(name = "resid" ,nullable = false)
    private int resID;

    @Column(name = "date" ,nullable = false)
    private Date date;

    @Column(name = "time" ,nullable = false)
    private Time time;

    //@Column(name = "userid", nullable = false)
    //private int userID;
}
