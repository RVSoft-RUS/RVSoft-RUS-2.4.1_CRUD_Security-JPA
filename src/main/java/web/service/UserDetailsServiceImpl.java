package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

@Service("userDetailsServiceImpl")
//@Transactional("jpaTrans")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    @Qualifier("userServiceImp")
    private UserService userService;


//    public UserDetailsServiceImpl(UserService userService) {
//        this.userService = userService;
//    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);
        if (user != null) {
//            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
//                    .username(user.getLogin())
//                    .password(user.getPassword())
//                    .authorities(user.getRoles())
//                    .build();
//            return userDetails;
            return user;
        } else {
            throw new UsernameNotFoundException("This user not found");
        }

    }
}
