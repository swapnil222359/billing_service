package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResDetailsAndMenu {

    private int resID;
    private String name;
    private int contactNumber;
    private String address;
    private String emailAddress;
    private String loginID;
    private List<Menu> menuDetails;
}
