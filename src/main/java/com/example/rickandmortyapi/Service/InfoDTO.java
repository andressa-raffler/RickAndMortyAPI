package com.example.rickandmortyapi.Service;

import lombok.Data;

@Data
public class InfoDTO {
    private Long count;
    private Long pages;
    private String next;
    private String prev;

}
