package you.you.domain.user;

import lombok.*;
import javax.persistence.*;


@Builder
@Getter @Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT IN MYSQL
    private Long id;

    @Column(name="email", unique = true)
    private String email;

}