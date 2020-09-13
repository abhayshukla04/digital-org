package com.engg.digitalorg.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GroupRequest {

    private String name;
    private String title;
    private String description;
    private String created_by;
    private String tribe;
    private String team;
    private String component;
    private String updated_by;
    private String active;
}
