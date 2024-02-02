package gong.example.account.service;

import gong.example.account.dto.SignInRequest;
import gong.example.account.entity.Client;
import gong.example.account.entity.Role;
import gong.example.account.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> clientList() {
        return clientRepository.findAll();
    }

    @Transactional
    public void saveClient(SignInRequest request) {
        clientRepository.save(Client.builder()
                .nickName(request.getNickName())
                .email("tmdghk503@naver.com")
                        .phoneNo(request.getPhoneNo())
                        .role(Role.ADMIN)
                        .userId(request.getUserId())
                        .isAuthPhone(true)
                        .isAgreeCondition(true)
                        .password(request.getPassword())
                .build());
//        Client client = Client.builder()
//                .nickName("seunghwa")
//                .email("tmdghk502@naver.com")
//                .userId("tmdghk502")
//                .isAgreeCondition(true)
//                .isAuthPhone(true)
//                .password("tmdghk9609!")
//                .phoneNo("01092134579")
//                .role(Role.ADMIN)
//                .userName("공승화")
//                .build();
//        clientRepository.save(client);

    }

}
