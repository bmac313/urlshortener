package com.github.urlshortener.controllers;

import com.github.urlshortener.models.Url;
import com.github.urlshortener.models.data.UrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UrlDao urlDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Custom URL Shortener");
        model.addAttribute("header", "Shorten a URL");
        model.addAttribute(new Url());
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processUrlForm(@Valid @ModelAttribute Url newUrl,
                                 Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Custom URL Shortener");
            model.addAttribute("header", "Shorten a URL");
            return "index";
        }

        urlDao.save(newUrl);

        return "redirect:/success";
    }

    //TODO: Create "not found" page template
    @RequestMapping(value = "/{shortUrlCode}", method = RequestMethod.GET)
    public String handleUrlRequest(@PathVariable("shortUrlCode") String shortUrlCode) {
        for (Url url : urlDao.findAll()) {
            if (url.getShortUrlCode().equals(shortUrlCode)) {
                return "redirect:" + url.getLongUrl();
            }
        }

        return "redirect:";
    }


    //TODO: Create submission success page template
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public @ResponseBody String successPage() {
        return "The form was successfully submitted!";
    }

}
