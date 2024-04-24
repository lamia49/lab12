package org.example.lab12.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//        @NotNull
//        @Column(columnDefinition = "varchar(50) not null")
        private String title;
//           @NotNull
//        @Column(columnDefinition = "varchar(250) not null")
        private String body;
        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        @JsonIgnore
        private Users user;
}
