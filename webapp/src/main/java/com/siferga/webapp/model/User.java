package com.siferga.webapp.model;
import com.netflix.eventbus.spi.Subscribe;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;

    // Example of Role enum, you can customize it as per your requirement
//    public enum Role {
//       ADMIN, USER, GUEST
//    }
}



//package com.siferga.webapp.model;

//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.HashSet;
//import java.util.Set;

//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//   @Column(nullable = false)
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles;
//}



