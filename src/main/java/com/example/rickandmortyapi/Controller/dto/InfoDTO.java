package com.example.rickandmortyapi.Controller.dto;

import lombok.Data;

@Data
public class InfoDTO {
    private Long count;
    private Long pages;
    private String next;
    private String prev;



}
