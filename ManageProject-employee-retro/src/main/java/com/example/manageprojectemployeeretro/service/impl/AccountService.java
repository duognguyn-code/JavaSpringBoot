package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.entity.Account;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountService {
    public static List<Account> listUser = new ArrayList<>();
    static {
        Account userKai = new Account(1, "kai", "123456");
        userKai.setRoles(new String[] { "ROLE_ADMIN" });
        Account userSena = new Account(2, "sena", "123456");
        userSena.setRoles(new String[] { "ROLE_USER" });
        listUser.add(userKai);
        listUser.add(userSena);
    }
    public List<Account> findAll() {
        return listUser;
    }
    public Account findById(int id) {
        for (Account user : listUser) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public boolean add(Account user) {
        for (Account userExist : listUser) {
            if (user.getId() == userExist.getId() || StringUtils.equals(user.getUsername(), userExist.getUsername())) {
                return false;
            }
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        listUser.add(user);
        return true;
    }
    public void delete(int id) {
        listUser.removeIf(user -> user.getId() == id);
    }
    public Account loadUserByUsername(String username) {
        for (Account user : listUser) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public boolean checkLogin(Account user) {
        for (Account userExist : listUser) {
            if (StringUtils.equals(user.getUsername(), userExist.getUsername())
                    && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
