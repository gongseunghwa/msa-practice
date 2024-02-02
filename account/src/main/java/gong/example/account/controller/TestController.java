package gong.example.account.controller;

import gong.example.account.dto.SignInRequest;
import gong.example.account.entity.Client;
import gong.example.account.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {
    private final ClientService clientService;

    @GetMapping
    public String getDataTest() {
        return clientService.clientList().stream().map(Client::getNickName).collect(Collectors.joining());
    }

    @PostMapping
    public void test(SignInRequest request) {
        clientService.saveClient(request);
    }
}
