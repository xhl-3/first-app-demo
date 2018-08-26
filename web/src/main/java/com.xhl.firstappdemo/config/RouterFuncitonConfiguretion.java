package com.xhl.firstappdemo.config;

import com.xhl.firstappdemo.domain.User;
import com.xhl.firstappdemo.repostory.UserRepostroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.ws.Response;
import java.util.Collection;

/**
 * Created by xhl on 2018/8/26.
 */
@Configuration
public class RouterFuncitonConfiguretion {
    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepostroy userRepostroy){

       return  RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    Collection<User> users=userRepostroy.findAll();
//                    Mono<ServerResponse> responseMono=null;
                    Flux<User> userFlux=Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
//                    return responseMono;

                });
    }
}
