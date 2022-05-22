package STUB.dao;


import STUB.util.JsonConverter;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private String name;
    private String email;
    private Integer age;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private List<Performance> performance = new ArrayList<>();

    public String toJson() {
        return JsonConverter.toJson(this);
    }

    public static User createRandomUser() {
        User user = new User();
        user.setName(Faker.instance().name().name());
        user.setAge(Faker.instance().random().nextInt(0, 80));
        user.setEmail(Faker.instance().pokemon().name() + "@otus.ru");
        user.setPerformance(List.of(new Performance(Faker.instance().random().nextLong(100),
                new Course(Faker.instance().country().name() + " for IT specialist", Faker.instance().random().nextLong(1_000_000)))));
        return user;
    }

}
