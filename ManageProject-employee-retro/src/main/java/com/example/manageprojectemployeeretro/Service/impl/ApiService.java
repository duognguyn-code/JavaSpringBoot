package com.example.manageprojectemployeeretro.Service.impl;

import com.example.manageprojectemployeeretro.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ApiService {
    private static final String API_URL = "https://63344d73433198e79dd52e49.mockapi.io/products";

    @Autowired
    private RestTemplate restTemplate;

    public List<UserDTO> getUsers(int page, int pageSize) {
        String url = API_URL + "?page=" + page + "&limit=" + pageSize;
        ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(url, UserDTO[].class);
        UserDTO[] usersArray = response.getBody();
        if (usersArray != null) {
            return Arrays.asList(usersArray);
        } else {
            return Collections.emptyList();
        }
    }
}
