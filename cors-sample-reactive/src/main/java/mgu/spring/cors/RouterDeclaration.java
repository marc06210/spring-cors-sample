package mgu.spring.cors;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Mono;

@Configuration
public class RouterDeclaration {
    
    private String msg = "It works!!!";
    
    @Bean
    public RouterFunction<ServerResponse> routeHello() {
        return RouterFunctions
            .route(GET("/granted-url"), this::hello)
            .andRoute(GET("/not-granted-url"), this::hello);
    }
    
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(new Msg(msg)));
    }
}

@Data
@AllArgsConstructor
class Msg {
    private String what;
    
}
