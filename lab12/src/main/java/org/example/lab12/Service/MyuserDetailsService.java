package org.example.lab12.Service;

import lombok.AllArgsConstructor;
import org.example.lab12.Api.ApiException;
import org.example.lab12.Model.Users;
import org.example.lab12.Repository.UserRepositry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyuserDetailsService  implements UserDetailsService {

  private final UserRepositry userRepositry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users users= userRepositry.findByUsername(username);
        if(users==null){
            throw new ApiException("Wrong");
        }
        return users;
    }
}
