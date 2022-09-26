package com.upwork.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller
public class MenuController {

    @Get
    @View("index")
    public HttpResponse<?> showMenu() {
        return HttpResponse.ok();
    }
}
