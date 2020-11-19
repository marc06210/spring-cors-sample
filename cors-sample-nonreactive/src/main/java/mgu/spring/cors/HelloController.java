package mgu.spring.cors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class HelloController {
    @GetMapping("/granted-url")
    public Msg corsUnprotectedHelloWorld() {
        return new Msg("It works!!!");
    }
    
    @GetMapping("/not-granted-url")
    public Msg corsProtectedHelloWorld() {
        return new Msg("It works!!! If yes it shouldn't from a browser");
    }
}

@Data
@AllArgsConstructor
class Msg {
    private String what;
    
}
