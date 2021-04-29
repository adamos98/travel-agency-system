package pl.softserve.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.softserve.Models.User;
import pl.softserve.dao.UserDAO;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    @Transactional
    public List<User> getAllCustomers(){
        return userDAO.getAllCustomers();
    }

    @Transactional
    public User getUser(int id){
        return userDAO.getUser(id);
    }

    @Transactional
    public User addUser(User user){
        return userDAO.addUser(user);
    }

    @Transactional
    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    @Transactional
    public void deleteUser(int id){
        userDAO.deleteUser(id);
    }

    @Transactional
    public User findByEmail(String email){
        return userDAO.findByEmail(email);
    }


}
