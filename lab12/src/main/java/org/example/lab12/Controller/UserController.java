package org.example.lab12.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.lab12.Model.Users;
import org.example.lab12.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid Users user) {
        userService.register(user);
        return ResponseEntity.status(200).body("registered successfully");
    }
   @PostMapping("/login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username ,@PathVariable String password){
        userService.login(username ,password);
        return ResponseEntity.status(200).body("login successfully");
    }

         @PostMapping("/logout/{username}/{password}")
    public ResponseEntity logout(){
        userService.logout();
        return ResponseEntity.status(200).body("logout successfully");
    }
    @PutMapping("/update/{username}")
    public ResponseEntity updateUser(@PathVariable String username,@RequestBody @Valid  Users user){
        userService.update(username,user);
         return ResponseEntity.status(200).body("Updated successfully");
    }

      @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteUser(@PathVariable String username){
        userService.delete(username);
         return ResponseEntity.status(200).body("deleted successfully");
    }


}
