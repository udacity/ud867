package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import udacity.android.com.libjoker.Joker;

/** An endpoint class we are exposing Joker*/
@Api(
        name = "jokerApi",
        version = "v1",
        resource = "joker",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokerEndpoint {

    @ApiMethod(name = "getJoke")
    public Joker getJoke(){
        Joker joker = new Joker();
        return joker;
    }
}
