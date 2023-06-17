package hm.authservice.repository;

import hm.authservice.authorities.Authorities;
import hm.authservice.users.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    private List<Users> listUsers = new ArrayList<>(Stream.of(new Users("Amir", "key"), new Users("Vova", "keys")).collect(Collectors.toList()));

    public List<Authorities> getUserAuthorities(Users users) {
        for (Users listUser : listUsers) {
            if (listUser.equals(users)) {
                return List.of(Authorities.READ);
            }
        }
        return List.of();
    }
}