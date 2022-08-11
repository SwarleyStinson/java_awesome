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
public class LogController {
    private final ObjectMapper mapper;

    @PostMapping("/log")
    @ResponseBody
    public String index(@RequestBody String body) {
        System.out.println("получен запрос: \n" + body + "\n--------------------");
        return "success";
    }
}
