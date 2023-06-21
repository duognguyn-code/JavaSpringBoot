//package com.example.manageprojectemployeeretro.controller.rest;
//
//import com.example.manageprojectemployeeretro.dao.UserRepository;
//import com.example.manageprojectemployeeretro.exception.Response;
//import com.example.manageprojectemployeeretro.service.TimeKeepService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/time-keep")
//@RequiredArgsConstructor
//public class TimeKeepController {
//    private final TimeKeepService timeKeepService;
//
//
//    UserRepository userService;
//
//
//
//    @GetMapping("/checkin/{code}")
//    public Response checkin(@PathVariable Integer code) {
//        String result = timeKeepService.checkin(code);
//        return Response.success(result);
//    }
//
//    @GetMapping("/checkout/{code}")
//    public Response checkout(@PathVariable Integer code) {
//        String result = timeKeepService.checkout(code);
//        return Response.success(result);
//    }
//
//    @PostMapping("/checkin")
//    public Response checkin() {
//        return Response.success("khong que security");
//    }
//}
