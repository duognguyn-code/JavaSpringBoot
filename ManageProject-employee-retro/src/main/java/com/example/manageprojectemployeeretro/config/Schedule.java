//package com.example.manageprojectemployeeretro.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class Schedule {
//    private static final Logger logger = LoggerFactory.getLogger(Schedule.class);
//    @Scheduled(cron = "*/2 * * * * *")
//    public void scheduleTaskWithCronExpression() {
//        logger.info("Send email to producers to inform quantity sold items");
//    }
//    //fixedRate : xác định khaorng thời gian cố định. DÙ phương thức  có kết thúc hay khoongphuwong thức tiếp theo sẽ đc ksich hoạt
//    // fixdelay : xác định khoảng thời gian cố định sau khi phương thức trước kết thúc sẽ có một khoảng time thì phương thưc tiếp theo đưojc gọi
//}
