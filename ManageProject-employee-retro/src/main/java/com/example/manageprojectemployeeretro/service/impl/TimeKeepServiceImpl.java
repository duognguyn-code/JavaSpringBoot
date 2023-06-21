//package com.example.manageprojectemployeeretro.service.impl;
//
//import com.example.manageprojectemployeeretro.dao.TimekeepingRepository;
//import com.example.manageprojectemployeeretro.dao.UserRepository;
//import com.example.manageprojectemployeeretro.dto.CustomUserDetails;
//import com.example.manageprojectemployeeretro.entity.Timekeeping;
//import com.example.manageprojectemployeeretro.entity.User;
//import com.example.manageprojectemployeeretro.exception.CustomException;
//import com.example.manageprojectemployeeretro.service.TimeKeepService;
//import com.example.manageprojectemployeeretro.utils.Constants;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class TimeKeepServiceImpl implements TimeKeepService {
////    private final TimekeepingRepository timekeepingRepository;
////    private final UserRepository userRepository;
////    public String returnEmail() {
////        String email = "";
////        Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        if (context instanceof org.springframework.security.core.userdetails.User) {
////            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////            email = user.getUsername();
////        } else {
////            CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////            email = user.getUser().getEmail();
////        }
//////        }
////        return email;
////    }
////
////    @Override
////    public String checkin(Integer code) {
////        String email = returnEmail();
////
////        User user = userRepository.findByEmailAndCode(email, code);
////        if (user == null) {
////            return "Employee ID does not exist or is not your code";
////        } else {
////            Timekeeping timekeeping = new Timekeeping();
////            timekeeping.setCheckin(Constants.getTimeNow());
////            timekeeping.setIdUser(user);
////            timekeepingRepository.save(timekeeping);
////            return user.getUsername() + " Successfully checked in";
////        }
////    }
////
////    @Override
////    public String checkout(Integer code) {
////        String email = returnEmail();
////        User user = userRepository.findByEmailAndCode(email, code);
////        if (user == null) {
////            return "Employee ID does not exist or is not your code";
////        } else {
////
////            Timekeeping timekeeping = timekeepingRepository.findByCodeEmpAndCheckin(Long.valueOf(userRepository.findByCode(code).getId()), new Date());
////            if (timekeeping.getCheckin().isEmpty()) {
////                timekeeping.setCheckin(Constants.getTimeNow());
////            }
////            timekeeping.setCheckout(Constants.getTimeNow());
////            timekeepingRepository.save(timekeeping);
////            return user.getUsername() + " Checkout successful";
////        }
////    }
////
////    @Override
////    public List<String> findAllEMPNotCheckin(Date date) {
////        List<String> result = userRepository.listEmpNotCheckin(date);
////        if (result.isEmpty()) {
////            throw new CustomException("There are no employees who have not checked in", HttpStatus.NOT_FOUND);
////        } else {
////            return result;
////        }
////    }
////
////    @Override
////    public List<String> findAllEMPNotCheckout(Date date) {
////        List<String> result = Optional.ofNullable(userRepository.listEmpNotCheckOut(date)).orElseThrow(() -> new CustomException("There are no employees who have not checked out", HttpStatus.NOT_FOUND));
////        return result;
////    }
//}
//
