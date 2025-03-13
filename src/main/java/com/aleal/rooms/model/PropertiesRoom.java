package com.aleal.rooms.model;


import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertiesRoom {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}
