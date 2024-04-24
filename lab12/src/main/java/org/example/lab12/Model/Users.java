package org.example.lab12.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Users implements UserDetails {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//     @NotNull
//     @Column(columnDefinition = "varchar(20) unique")
    private String username;
//       @NotNull
//     @Column(columnDefinition = "varchar(50)")
    private String password;
          @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Blog> blogs;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private Set<ToDo> todos;



}
