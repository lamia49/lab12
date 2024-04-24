package org.example.lab12.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab12.Api.ApiException;
import org.example.lab12.Model.Users;
import org.example.lab12.Repository.UserRepositry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
      private final UserRepositry userRepositry;
    public void register(Users user){
        String hashPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);
        userRepositry.save(user);
    }

       public void login(String username ,String password){
       Users user = userRepositry.findUsersByUsernameAndPassword(username,password );
    }

      public void logout(){
    }

    public void update(String username,Users user){
        Users user1= userRepositry.findByUsername(username);

        if(user1==null){
                 throw  new ApiException("User name Not Found!");
        }
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            userRepositry.save(user1);
    }
   public void delete(String username){
          Users user= userRepositry.findByUsername(username);
          if(user==null){
               throw  new ApiException("User name Not Found!");
        }else
            userRepositry.delete(user);
    }

      public List<Users> getAllUsers(){
        return userRepositry.findAll();
    }

}
