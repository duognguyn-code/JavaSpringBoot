package com.example.manageprojectemployeeretro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String message;
}
