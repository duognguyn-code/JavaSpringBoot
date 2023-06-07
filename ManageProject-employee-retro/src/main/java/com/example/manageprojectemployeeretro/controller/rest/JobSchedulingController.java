package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.dto.TaskDefinition;
import com.example.manageprojectemployeeretro.service.impl.TaskDefinitionBean;
import com.example.manageprojectemployeeretro.service.impl.TaskSchedulingService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/schedule")
public class JobSchedulingController {
    @Autowired
    private TaskSchedulingService taskSchedulingService;

    @Autowired
    private TaskDefinitionBean taskDefinitionBean;

    @PostMapping(path="/taskdef", consumes = "application/json", produces="application/json")
    public void scheduleATask(@RequestBody TaskDefinition taskDefinition) {
        taskDefinitionBean.setTaskDefinition(taskDefinition);
        taskSchedulingService.scheduleATask(UUID.randomUUID().toString(), taskDefinitionBean, taskDefinition.getCronExpression());
    }

    @GetMapping(path="/remove/{jobid}")
    public void removeJob(@PathVariable String jobid) {
        taskSchedulingService.removeScheduledTask(jobid);
    }
}
