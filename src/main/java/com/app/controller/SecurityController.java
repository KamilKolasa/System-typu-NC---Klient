package com.app.controller;

import com.app.model.security.AuthenticationUserDto;
import com.app.model.create.CreateUserDto;
import com.app.model.security.ForgetPasswordDto;
import com.app.model.security.NewPasswordDto;
import com.app.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/security")
public class SecurityController {

    private final SecurityService securityService;

    @GetMapping("/registration")
    public String getRegister(Model model) {
        model.addAttribute("createUserDto", new CreateUserDto());
        return "security/registration";
    }

    @PostMapping("/registration")
    public String postRegister(@ModelAttribute CreateUserDto createUserDto, Model model) {
        securityService.register(createUserDto);
        return "redirect:/security/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("authenticationUser", new AuthenticationUserDto());
        return "security/login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute AuthenticationUserDto authenticationUserDto, Model model) {
        securityService.login(authenticationUserDto);
        return "redirect:/";
    }

    @GetMapping("/remember")
    public String getRemember(Model model) {
        model.addAttribute("forgetPassword", new ForgetPasswordDto());
        return "security/rememberPassword";
    }

    @PostMapping("/remember")
    public String postRemember(@ModelAttribute ForgetPasswordDto forgetPasswordDto, Model model) {
        securityService.generateResetPasswordToken(forgetPasswordDto);
        return "redirect:/security/login";
    }

    @PostMapping("/logout")
    public String postLogout() {
        securityService.logout();
        return "redirect:/";
    }

}
