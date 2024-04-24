package org.example.lab12.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab12.Api.ApiException;
import org.example.lab12.Model.Blog;
import org.example.lab12.Model.Users;
import org.example.lab12.Repository.RepositryBlog;
import org.example.lab12.Repository.UserRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final RepositryBlog repositryBlog;
    private final UserRepositry userRepositry;
    public List<Blog> getAllBlog() {
        return repositryBlog.findAll();
    }
   public void addBlogs(Blog blog, Integer userId){
        Users user = userRepositry.findUsersById(userId);
        blog.setUser(user);
        repositryBlog.save(blog);
    }


  public void updateBlogs(Users user ,Integer blogID ,Blog blog ){
          Blog blog1=repositryBlog.findBlogById(blogID);
          if(blogID==null){
              throw  new ApiException("not found ");
          }
         if(blog1.getUser().getId()==user.getId()){
             blog1.setTitle(blog.getTitle());
          repositryBlog.save(blog1);
         } else
             throw new ApiException("not allows");

      }

          public void deleteBlog(Users user,Integer blogID){
               Blog blog=repositryBlog.findBlogById(blogID);
          if(blog.getId().equals(blogID)) {
              repositryBlog.delete(blog);
          }else
             throw new ApiException("not allows");
      }



          public List<Blog> getUserBlogs(Integer userId){
        Users user = userRepositry.findUsersById(userId);
        return repositryBlog.findAllByUser(user);
    }

    public Blog getBlogById(Integer blogID){
        return repositryBlog.findBlogById(blogID);
    }

    public List<Blog> getBlogByTitle(String title){
        return repositryBlog.findBlogByTitle(title);
    }


}
