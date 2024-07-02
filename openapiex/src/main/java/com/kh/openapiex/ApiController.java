package com.kh.openapiex;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/back")
    public String back(Model model) throws IOException {
        String result =apiService.getHospitalIfo();
        model.addAttribute("result",result);
        return "back";
    }

    @ExceptionHandler(IOException.class)
    public String handleIOException(IOException e) {
        e.printStackTrace();
        return "redirect:/front";
    }

    @GetMapping("/front")
    public void front() {
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
