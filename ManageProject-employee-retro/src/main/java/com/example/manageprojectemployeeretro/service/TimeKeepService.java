package com.example.manageprojectemployeeretro.service;

import java.util.Date;
import java.util.List;

public interface TimeKeepService {
    String checkin(Integer code);

    String checkout(Integer code);

    List<String> findAllEMPNotCheckin(Date date);
    List<String> findAllEMPNotCheckout(Date date);
}
