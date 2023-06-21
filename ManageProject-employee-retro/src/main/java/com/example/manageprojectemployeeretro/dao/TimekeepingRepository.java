package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Timekeeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TimekeepingRepository  extends JpaRepository<Timekeeping, Long> {
    @Query(value = "SELECT t FROM Timekeeping t WHERE t.idUser.id = ?1 and t.checkin between ?2 and ?3 and t.checkout between ?2 and ?3")
    List<Timekeeping> findByCodeEmpInterval(String codeEmp, String dateFrom, String dateTo);

    @Query(value = "SELECT t FROM Timekeeping t WHERE t.idUser.id = ?1 and t.createAt=?2")
    Timekeeping findByCodeEmpAndCheckin(Long codeEmp, Date date);
}
