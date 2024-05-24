package org.example.pocspringpagablesecurity.app;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class MyController {

    @GetMapping("/")
    @ResponseBody
    public String hello(@AuthenticationPrincipal MyUserDetails user,
                        final Authentication authentication) {
        System.out.printf("authentication = %s%n", authentication);
        System.out.printf("AuthenticationPrincipal = %s%n", user);
        return "Hello %s!<br/><a href=/login>Go to login</a>".formatted(user);
    }

}
