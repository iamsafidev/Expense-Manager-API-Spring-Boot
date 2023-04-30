package pk.iamsafidev.expensetrackerapi.service;

import pk.iamsafidev.expensetrackerapi.entity.User;
import pk.iamsafidev.expensetrackerapi.entity.UserModel;

public interface UserService {

    User createUser(UserModel user);

    User read();

    User update(User user);

    void delete();

    User getLoggedInUser();
}
