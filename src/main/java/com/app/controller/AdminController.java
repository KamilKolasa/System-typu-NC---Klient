package com.app.controller;

import com.app.model.CategoryDto;
import com.app.model.create.*;
import com.app.model.enums.Quality;
import com.app.model.enums.TypeInternet;
import com.app.service.AdminService;
import com.app.service.TokensService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/settings")
public class AdminController {

    private final TokensService tokensService;
    private final AdminService adminService;

    // ===================================
    // =========== UZYTKOWNICY ===========
    // ===================================

    @GetMapping("/users")
    public String getSettingsUsers(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("allUsers", adminService.getAllUsers().getData());//jeszcze nalezy dokonczyc, zwiekszyc zawartosc klasy GetUserDto
        model.addAttribute("allAdmins", adminService.getAllAdmins().getData());//nie dziala, nie wiem czemu nie widzi typu objectu
        return "admin/users";
    }

    // ===================================
    // ============= OFERTY ==============
    // ===================================

    @GetMapping("/category")
    public String getSettingsCategorys(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("allCategorys", adminService.countCategories().getData());
        model.addAttribute("addCategory", new CategoryDto());
        return "admin/offers/category";
    }

    @PostMapping("/category")
    public String postSettingsCategorys(Model model, @ModelAttribute CategoryDto categoryDto) {
        model.addAttribute("userRole", tokensService.getRole());
        return "redirect:/admin/offers/category";
    }

    @GetMapping("/offers")
    public String getSettingsOffers(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("allPacks", adminService.getAllPacks().getData());
        return "admin/offers/offers";
    }

    @PostMapping("/offers")
    public String postSettingsOffers(Model model, @ModelAttribute CreatePackDto createPackDto) {
        model.addAttribute("userRole", tokensService.getRole());
//        adminService.addPack(createPackDto);
        return "redirect:/admin/offers/offers";
    }

    @GetMapping("/offersChannels")
    public String getSettingsOffersChannels(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("addChannel", new CreateChannelDto());
        model.addAttribute("categorys", adminService.getAllCategorys().getData());
        model.addAttribute("allChannels", adminService.getAllChannels().getData());
        return "admin/offers/offersChannels";
    }

    @PostMapping("/offersChannels")
    public String postSettingsOffersChannels(Model model, @ModelAttribute CreateChannelDto createChannelDto) {
        model.addAttribute("userRole", tokensService.getRole());
//        adminService.addChannel(createChannelDto);
        return "redirect:/admin/offers/offersChannels";
    }

    @GetMapping("/offersFilms")
    public String getSettingsOffersFilms(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("addFilm", new CreateFilmDto());
        model.addAttribute("qualitys", Quality.values());
        model.addAttribute("categorys", adminService.getAllCategorys().getData());
        model.addAttribute("allFilms", adminService.getAllFilms().getData());
        return "admin/offers/offersFilms";
    }

    @PostMapping("/offersfilms")
    public String postSettingsOffers(Model model, @ModelAttribute CreateFilmDto createFilmDto) {
        model.addAttribute("userRole", tokensService.getRole());
        adminService.addFilm(createFilmDto);
        return "redirect:/admin/offers/offersFilms";
    }

    @GetMapping("/offersInternets")
    public String getSettingsOffersInternets(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("addPackInternet", new CreatePackInternetDto());
        model.addAttribute("typeInternets", TypeInternet.values());
        model.addAttribute("allPackInternets", adminService.getAllPackInternets().getData());
        return "admin/offers/offersInternets";
    }

    @PostMapping("/offersInternets")
    public String postSettingsOffersInternets(Model model, @ModelAttribute CreatePackInternetDto createPackInternetDto) {
        model.addAttribute("userRole", tokensService.getRole());
//        adminService.addPackInternet(createPackInternetDto);
        return "redirect:/offers/offersInternets";
    }

    @GetMapping("/offersPhones")
    public String getSettingsOffersPhones(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("addPackPhone", new CreatePackPhoneDto());
        model.addAttribute("allPackPhones", adminService.getAllPackPhones().getData());
        return "admin/offers/offersPhones";
    }

    @PostMapping("/offersPhones")
    public String postSettingsOffersPhones(Model model, @ModelAttribute CreatePackPhoneDto createPackPhoneDto) {
        model.addAttribute("userRole", tokensService.getRole());
//        adminService.addPackPhone(createPackPhoneDto);
        return "redirect:/offers/offersPhones";
    }

    @GetMapping("/offersTvs")
    public String getSettingsOffersTvs(Model model) {
        model.addAttribute("userRole", tokensService.getRole());
        model.addAttribute("addPackTv", new CreatePackTvDto());
        model.addAttribute("allPackTvs", adminService.getAllPackTvs().getData());
        return "admin/offers/offersTvs";
    }

    @PostMapping("/offersTvs")
    public String postSettingsOffersTvs(Model model, @ModelAttribute CreatePackTvDto createPackTvDto) {
        model.addAttribute("userRole", tokensService.getRole());
//        adminService.addPackTv(createPackTvDto);
        return "redirect:/offers/offersTvs";
    }
}
