package org.billingservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by sony on 20-09-2017.
 */
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
    private List< MenuDetails > menuDetails;
}
