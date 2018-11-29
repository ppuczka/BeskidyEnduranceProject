package pl.coderslab.beskidyenduranceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.beskidyenduranceproject.entity.Role;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.RoleRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JavaMailSender sender;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("tzn ");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

    }

}
