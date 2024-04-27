package com.HMB.HW14TodoList.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Note {
    private UUID id;
    private String title;
    private String content;

}
