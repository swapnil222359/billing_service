package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sony on 04-10-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tabledetails")
public class TableDetails {

    @Column(name = "resID",unique = true, nullable = false)
    int resID;

    @Column(name = "itemID",unique = true, nullable = false)
    int itemID;

    @Column(name = "quantity",unique = true, nullable = false)
    String quantity;

    @Column(name = "tableID",unique = true, nullable = false)
    int tableID;
}
