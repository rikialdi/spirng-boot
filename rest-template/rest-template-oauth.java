package com.bawahtangga.Test;


import com.bawahtangga.model.security.User;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping("/test/")
public class RestTemplae {

    @Autowired
    RestTemplate getRestTemplate;


        @GetMapping("test/{id}")
        public String GetChartByID(@PathVariable("id") String id )   {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization","bearer "+id);

        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return getRestTemplate.exchange("http://localhost:8080/secured/user/user_role", HttpMethod.GET, entity, String.class).getBody();
    }

    @PostMapping("test/{id}")
    public String post(@PathVariable("id") String id , @Valid @RequestBody User s)   {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization","bearer "+id);

        HttpEntity <User> entity = new HttpEntity<User>(s,headers);


        return getRestTemplate.exchange("http://localhost:8080/secured/user/login", HttpMethod.POST, entity, String.class).getBody();
    }

//    @RequestMapping(value = "getouth", method = RequestMethod.POST
//            , produces = {"application/json", "application/xml"}
//            ,  consumes = {"application/x-www-form-urlencoded"})

//    @PostMapping("getouth")

//    @RequestMapping(value = "getouth", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PostMapping("getouth")
    public  String getosuth()   { //@Valid @RequestBody request ss

        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");


        String authString = "dibawahtangga-read-write-client" + ":" + "spring-security-oauth2-read-write-client-password1234";
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        System.out.println("authStringEncauthStringEnc="+authStringEnc);
//        String authHeaderValue = "Basic " + Base64.ge().encodeToString(userPass.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, "Basic ZGliYXdhaHRhbmdnYS1yZWFkLXdyaXRlLWNsaWVudDpzcHJpbmctc2VjdXJpdHktb2F1dGgyLXJlYWQtd3JpdGUtY2xpZW50LXBhc3N3b3JkMTIzNA==");

//        headers.set("username" , "admin@gmail.com");
//        headers.set("password","admin1234");
//        headers.set("grant_type","password" );
//        headers.set("client_id","dibawahtangga-read-write-client" );
//        request s = new request();
//        s.setUsername("admin@gmail.com");
//        s.setPassword("admin1234");
//        s.setGrant_type("password");
//        s.setClient_id("dibawahtangga-read-write-client");

    JSONObject jsonCredentials = new JSONObject();
    jsonCredentials.put("username", "admin@gmail.com");
    jsonCredentials.put("password", "admin1234");
    jsonCredentials.put("grant_type", "password");
    jsonCredentials.put("client_id", "dibawahtangga-read-write-client");
//        jsonCredentials.s

//    Log.getLog("as", ">>>>>>>>>>>>>>>> JSON credentials " + jsonCredentials.toString());
        HttpEntity <String> entity = new HttpEntity<String>(jsonCredentials.toString(),headers);


        return getRestTemplate.exchange("http://192.168.1.207:8080/api/oauth/token", HttpMethod.POST, entity, String.class).getBody();
    }


    private HttpHeaders createHttpHeaders(String user, String password)
    {
        String authString = user + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + authStringEnc);

        return headers;
    }

    @PostMapping("getouth122") //cioba
    private String doYourThing()
    {
        String theUrl = "http://192.168.1.207:8080/api/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        try {
            String name = "dibawahtangga-read-write-client";
            String password = "spring-security-oauth2-read-write-client-password1234";
            HttpHeaders headers = createHttpHeaders(name,password);
//            headers.add("grant_type","password");
//            headers.add("username" , "admin@gmail.com");
//            headers.add("password","admin1234");


            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.POST, entity, String.class);
            System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
            return response.getBody();
        }
        catch (Exception eek) {
            System.out.println("** Exception: "+ eek.getMessage());
        }
        return  "SD";
    }
    @PostMapping("OUATH_BISA")
    public String test1() throws UnirestException {
        RestTemplate restTemplate = new RestTemplate();
        String webPage = "http://192.168.1.207:8080/api/oauth/token";
        String name = "dibawahtangga-read-write-client";
        String password = "spring-security-oauth2-read-write-client-password1234";

        String authString = name + ":" + password;
        System.out.println("auth string: " + authString);
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        System.out.println("Base64 encoded auth string: " + authStringEnc);
//ini bisa
//        JsonNode jsonResponse = Unirest.post("http://192.168.1.207:8080/api/oauth/token")
////                .header("Content-Type", "application/json")
////                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("authorization", "Basic "+authStringEnc)
////                .header("authorization", "Basic ZGliYXdhaHRhbmdnYS1yZWFkLXdyaXRlLWNsaWVudDpzcHJpbmctc2VjdXJpdHktb2F1dGgyLXJlYWQtd3JpdGUtY2xpZW50LXBhc3N3b3JkMTIzNA==")
//
//                .field("grant_type", "password")
//                .field("username", "admin@gmail.com")
//                .field("password", "admin1234")
//                .field("client_id", "dibawahtangga-read-write-client")
//                .asJson()
//                .getBody();
        HttpResponse<JsonNode> jsonResponse= Unirest.post("http://192.168.1.207:8080/api/oauth/token")

//                JsonNode jsonResponse = Unirest.post("http://192.168.1.207:8080/api/oauth/token")
//                .header("Content-Type", "application/json")
//                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("authorization", "Basic "+authStringEnc)
//                .header("authorization", "Basic ZGliYXdhaHRhbmdnYS1yZWFkLXdyaXRlLWNsaWVudDpzcHJpbmctc2VjdXJpdHktb2F1dGgyLXJlYWQtd3JpdGUtY2xpZW50LXBhc3N3b3JkMTIzNA==")

                .queryString("grant_type", "password")
                .queryString("username", "admin@gmail.com")
                .queryString("password", "admin1234")
                .queryString("client_id", "dibawahtangga-read-write-client")
                .asJson();

        Gson gson = new Gson();
        String responseJSONString = jsonResponse.getBody().toString();
        JSONObject re = jsonResponse.getBody().getObject();
//        MyResponseObject myObject = gson.fromJson(responseJSONString, String.class);
        System.out.println( "access_token="+re.getString("access_token"));
        System.out.println( "refresh_token="+re.getString("refresh_token"));
        System.out.println( "scope="+re.getString("scope"));
        System.out.println( "token_type="+re.getString("token_type"));

        return jsonResponse.getBody().toString();
    }




    @PostMapping("getouth_bt")
    public String getouth_bt()   {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("username" , "admin@mail.com"); //client
        headers.set("password","password");
        headers.set("grant_type","password");

//        headers.set("client_id","dibawahtangga-read-write-client");
//        headers.set("client_secret","spring-security-oauth2-read-write-client-password1234");
        String authString = "my-client-id" + ":" + "password";
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
//        String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString(userPass.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, "Basic " +authStringEnc);


        HttpEntity <String> entity = new HttpEntity<String>(headers);


        return getRestTemplate.exchange("http://192.168.1.207:8124/api/oauth/token", HttpMethod.POST, entity, String.class).getBody();
    }
    @PostMapping("getbca")
    public Object getbca()   {



        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("username" , "client_id"); //client
        headers.set("password","client_secret");
        headers.set("grant_type","client_credentials");

//        headers.set("client_id","my-client-id"); //oauth
//        headers.set("client_secret","password"); //oauth

        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return getRestTemplate.exchange("https://sandbox.bca.co.id/api/oauth/token", HttpMethod.POST, entity, String.class).getBody();

            }



    /*
    1 . get http://localhost:8080/test/test/66b50ad7-561d-46b1-a170-66dca8216930

  2. post http://localhost:8080/test/test/66b50ad7-561d-46b1-a170-66dca8216930

  3. gagal get ousth http://localhost:8080/secured/test/getouth

4. bisa http://localhost:8080/test/OUATH_BISA


{
"username":"admin@gmail.com",
"password":"password",
"grant_type":"password",
"client_id":"dibawahtangga-read-write-client"
}

     */
}
