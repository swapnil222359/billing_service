package org.billingservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sony on 21-09-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MenuItems {

    private int  itemId;
    private String itemName;
    private String qty;
    private double price;

}
