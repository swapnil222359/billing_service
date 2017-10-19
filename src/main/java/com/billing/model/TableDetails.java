package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sony on 04-10-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "table_details")
public class TableDetails implements Serializable {

    @EmbeddedId
    private TdetailsID detailsID;

    @Column(name = "quantity",unique = true,nullable = false)
    Integer quantity;
}
