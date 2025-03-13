package com.aleal.reservations.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PropertiesReservations {

    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;

}
