package nekogochan.controller;

import nekogochan.entity.Client;
import nekogochan.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController extends DefaultEntityController<Client> {
    public ClientController(ClientService service) {
        super(service);
    }
}
