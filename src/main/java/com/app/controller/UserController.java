package com.app.controller;

import com.app.model.create.CreateFilmDto;
import com.app.model.enums.Quality;
import com.app.service.AdminService;
import com.app.service.TokensService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/personalization")
public class UserController {

    private final TokensService tokensService;

    @GetMapping("/generalSettings")
    public String getGeneralSettings(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        return "user/generalSettings";
    }
}
