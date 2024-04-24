package org.example.lab12.Repository;

import org.example.lab12.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
    Users findUsersByUsernameAndPassword(String username,String password);
    Users findUsersById(Integer id);
}
