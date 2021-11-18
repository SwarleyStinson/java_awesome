package ru.stepanov.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.stepanov.webapp.model.BookReq;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    private final ObjectMapper mapper;

    @GetMapping("/")
    public String index(Model model) {
        System.out.println("ЗАШЕЛ");
        return "index";
    }

    @SneakyThrows
    @PostMapping(
            value = "/book",
            produces = {"application/json"},
            consumes = {"application/json"})
    @ResponseBody
    public String addBook(@RequestBody BookReq req) {
        log.warn(req.toString());
        req.setExist("YES");
        Thread.sleep(3_000);
        return mapper.writeValueAsString(req);
    }
}
