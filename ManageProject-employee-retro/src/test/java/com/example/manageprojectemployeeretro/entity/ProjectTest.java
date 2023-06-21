//package com.example.manageprojectemployeeretro.entity;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.junit.jupiter.api.*;
//
//import java.time.LocalDate;
//
//public class ProjectTest {
//
//    private static SessionFactory sessionFactory;
//    private Session session;
//    private Transaction transaction;
//    private Project projectUnderTest;
//    private Project projectUnder;
//
//    @BeforeAll
//    static void setUp() {
//        // Create configuration object and configure Hibernate
//        Configuration configuration = new Configuration().configure();
//
//        // Build the session factory
//        sessionFactory = configuration.buildSessionFactory();
//    }
//
//    @BeforeEach
//    void setUpBeforeEach() {
//        // Open a new session before each test
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//    }
//
//    @AfterEach
//    void tearDownAfterEach() {
//        // Commit and close the session after each test
//        transaction.commit();
//        session.close();
//    }
//    @BeforeEach
//    void setUp() {
//
//        projectUnderTest = new Project(0L, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(7));
//        projectUnder = new Project();
//    }
//
//
//
//    @Test
//    void getIdTest() {
//        // Save the project to the database
//        session.save(projectUnderTest);
//        session.flush();
//
//        // Retrieve the project from the database
//        Project result = session.get(Project.class, projectUnderTest.getId());
//
//        // Verify the results
//        Assertions.assertEquals(projectUnderTest.getId(), result.getId());
//    }
//
//    @Test
//    void getNameTest() {
//        // Run the test
//        String result = projectUnderTest.getName();
//
//        // Verify the results
//        Assertions.assertEquals("Project 1", result);
//    }
//}
