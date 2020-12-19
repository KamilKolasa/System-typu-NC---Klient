package com.app.controller;

import com.app.service.MainService;
import com.app.service.TokensService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final TokensService tokensService;
    private final MainService mainService;

    @GetMapping("/")
    public String ncPlus(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("listThreeOffers", mainService.getThreeOffers().getData().get(0));
        return "ncPlus";
    }

}
