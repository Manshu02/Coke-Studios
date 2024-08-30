package com.example.CokeStudios.repository;

import com.example.CokeStudios.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    public Users findByuname(String uname);
}
