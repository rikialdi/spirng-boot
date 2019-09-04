package com.dibawahtangga.api.Confiq;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("WeakerAccess")
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterConfiguration implements Filter {
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
    /*

    oh: http://182.16.178.172/pos-kawasaki-version-2/login

    var login_data = {username: "admin@mail.com", password: "password", grant_type: "password", client_id:"my-client-id", client_secret: "password"}
$.ajax({
 crossDomain: true,
 url: "http://localhost:8124/api/v1/cart/1",

 type: "GET",
 headers: {
   "Content-Type": "application/json",
   "Accept": "application/json",

"Authorization":"Bearer SFeNT53BQqAMu1vcBGADmwTQ"
 },
 processData: false,
}).done(function (response) {
 console.log(response);
});



get ouath

var login_data = {username: "admin@mail.com", password: "password", grant_type: "password", client_id:"my-client-id", client_secret: "password"}
$.ajax({
 crossDomain: true,
 url: "http://192.168.1.207:8124/api/oauth/token",
 type: "POST",
 headers: {
   "Content-Type": "application/json",
   "Accept": "application/json",
   "Cache-Control": "no-cache"
 },
 processData: false,
 data: JSON.stringify(login_data)
}).done(function (response) {
 console.log(response);
});

: http://182.16.178.172/pos-kawasaki-version-2/login
     */
}
