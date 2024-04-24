package org.example.lab12.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab12.Model.Blog;
import org.example.lab12.Model.Users;
import org.example.lab12.Service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BloController {
     private final BlogService blogService;

      @GetMapping("/get-all")
    public ResponseEntity getAllBlogs(){
        return ResponseEntity.status(200).body(blogService.getAllBlog());
    }

@PostMapping("/add")
    public ResponseEntity addTodos(@AuthenticationPrincipal Users user, @RequestBody @Valid Blog blog){
        blogService.addBlogs(blog, user.getId());
        return ResponseEntity.status(200).body("Blog added successfully");
    }

    @PutMapping("/update/{blogId}")
    public ResponseEntity updateToDo(@AuthenticationPrincipal Users user,@PathVariable Integer blogId ,@RequestBody @Valid Blog blog ){
         blogService.updateBlogs(user,blogId,blog);
         return ResponseEntity.status(200).body("Blog updated successfully");
    }

   @DeleteMapping("/delete/{blogId}")
    public ResponseEntity deleteToDo(@AuthenticationPrincipal Users user, @PathVariable Integer blogId){

        blogService.deleteBlog(user,blogId);
         return ResponseEntity.status(200).body("Todo delete successfully");
    }



      @GetMapping("/get-user-blogs")
    public ResponseEntity getUserBlogs(@AuthenticationPrincipal Users user){
        return ResponseEntity.status(200).body(blogService.getUserBlogs(user.getId()));
    }

         @GetMapping("/by-id/{blogId}")
    public ResponseEntity getById(@PathVariable Integer blogId){
        return ResponseEntity.status(200).body(blogService.getBlogById(blogId));
    }

           @GetMapping("/by-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(title));
    }


}
