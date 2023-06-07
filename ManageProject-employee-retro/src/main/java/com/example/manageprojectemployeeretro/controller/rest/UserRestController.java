package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.config.Config;
import com.example.manageprojectemployeeretro.config.TransactionConfig;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.dto.ProjectProjection;
import com.example.manageprojectemployeeretro.entity.Account;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.service.impl.AccountService;
import com.example.manageprojectemployeeretro.service.impl.JwtService;
import com.example.manageprojectemployeeretro.service.impl.ProjectServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private TransactionConfig transactionConfig;
    @Autowired
    private AccountService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public JavaMailSender mailSender;

    @Autowired
    public Config config;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService123;



    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @RequestMapping("/sendmail")
    public String sendEmail() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                + "<img src='https://ncc.asia/images/logo/logo.png'>";
        message.setContent(htmlMsg, "text/html");

        FileSystemResource file = new FileSystemResource(new File("test.txt"));
        helper.addAttachment("Demo Mail", file);

        String[] recipients = {"email1@example.com", "email2@example.com", "email3@example.com"};
        helper.setTo(recipients);

        helper.setSubject("Demo Send Email");
        mailSender.send(message);
        return "Email Sent Sucessfully!";
    }
    /* ---------------- GET ALL USER ------------------------ */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllUser() {
        return new ResponseEntity<List<Account>>(userService.findAll(), HttpStatus.OK);
    }
    /* ---------------- GET USER BY ID ------------------------ */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        Account user = userService.findById(id);
        if (user != null) {
            return new ResponseEntity<Object>(user, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Not Found User", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody Account user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return new ResponseEntity<>("Username and password are required!", HttpStatus.BAD_REQUEST);
        }
        Account existingUser = userService.loadUserByUsername(user.getUsername());
        if (existingUser != null) {
            return new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
        }

        // Mã hóa mật khẩu trước khi thêm người dùng mới
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        if (userService.add(user)) {
            return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("User Existed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        userService.delete(id);
        return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody Account user) {
        String result = "";
        HttpStatus httpStatus = null;
        try {
            if (userService.checkLogin(user)) {
                result = jwtService.generateTokenLogin(user.getUsername());
                httpStatus = HttpStatus.OK;
            } else {
                result = "Wrong userId and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception ex) {
            result = "Server Error";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<String>(result, httpStatus);
    }

    @GetMapping("/users/{userId}/role")
    public String getUserRoleName(@PathVariable int userId) {
        User user = userRepository.findUserById(userId);
        String user1 = String.valueOf(userRepository.findUserById(userId));
        String roleName = user.getRoleName();
        return roleName;
    }
    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok(config.Getdata());
    }
    @GetMapping("/test1")
    public ResponseEntity test1() {
        return ResponseEntity.ok(transactionConfig.getdata());
    }
    @GetMapping("")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(userService123.getAllUser());


        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @GetMapping(value = "user")
    public ResponseEntity<?> getAndSaveListUser() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://stg-api-hrmv2.nccsoft.vn/api/services/app/CheckIn/GetUserForCheckIn";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        List<String> rs = Collections.singletonList(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        JsonNode resultNode = rootNode.get("result");
        List<User> users = mapper.readValue(resultNode.toString(), new TypeReference<List<User>>(){});
        for(User user : users){
            System.out.println(user);
        }


        userService123.saveUser(users);

        return new ResponseEntity<>("luu thanh cong", HttpStatus.OK);
    }
    @GetMapping(value = "/projectByname/{name}")
    public ResponseEntity<List<ProjectProjection>> getProjectByName(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(projectService.findProjectsByName(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/createUsers/even")
    public ResponseEntity<String> createUser(User user) {
        userService123.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }
}
