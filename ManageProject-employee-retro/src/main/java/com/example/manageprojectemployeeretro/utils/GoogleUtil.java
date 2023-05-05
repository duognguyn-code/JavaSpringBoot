//package com.example.manageprojectemployeeretro.utils;
//
//import java.io.IOException;
//import org.apache.http.client.ClientProtocolException;
//
//public class GoogleUtil {
//    public static String getToken(final String code) throws ClientProtocolException, IOException {
//        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
//                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
//                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
//                        .add("redirect_uri",Constants.GOOGLE_REDIRECT_URI).add("code", code)
//                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
//                .execute().returnContent().asString();
//
//        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
//        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
//        return accessToken;
//    }
//
//    public static UserGoogleDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
//        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
//        String response = Request.Get(link).execute().returnContent().asString();
//        UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);
//        System.out.println(googlePojo);
//        return googlePojo;
//
//    }
//}
