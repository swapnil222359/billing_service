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
public class TableDetailsPK implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "restaurantId",unique = true, nullable = false)
    private int restaurantId;

    @Column(name = "tableId",unique = true, nullable = false)
    private int tableId;

    @Column(name = "itemId",unique = true, nullable = false)
    private int itemId;
}
