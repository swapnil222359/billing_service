package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by sony on 14-10-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class TdetailsID implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "resID",unique = true, nullable = false)
    private int resID;

    @Column(name = "tableID",unique = true, nullable = false)
    private int tableID;

    @Column(name = "itemID",unique = true, nullable = false)
    private int itemID;
}
