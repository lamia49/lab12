package org.example.lab12.Repository;

import org.example.lab12.Model.Blog;
import org.example.lab12.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositryBlog extends JpaRepository<Blog, Integer> {
    Blog findBlogById(Integer id);
Blog findBlogByUser(Users user);
List<Blog>findAllByUser(Users user);
List<Blog> findBlogByTitle(String title);
}
