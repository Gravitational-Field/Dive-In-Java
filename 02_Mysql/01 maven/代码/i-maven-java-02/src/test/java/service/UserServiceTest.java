package service;

import com.imcode.service.UserService;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
    }

    @Test
    public void sayHello() {

        userService.sayHello();

    }
}