package com.example.tfttournament.dao;

import com.example.tfttournament.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountDao extends JpaRepository<User,String>{

    @Query("select p from User p where p.username=?1")
    User findbyUsername(String username);

}
