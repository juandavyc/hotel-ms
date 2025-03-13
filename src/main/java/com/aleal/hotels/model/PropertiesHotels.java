package com.aleal.hotels.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertiesHotels {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}


