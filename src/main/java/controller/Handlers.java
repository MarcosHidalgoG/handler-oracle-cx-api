/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PartnerJson;
import model.PartnerContact;
import model.PartnersJson;
import org.apache.http.client.methods.HttpRequestBase;
import propertiesReader.PropertiesReader;

/**
 *
 * @author Jorge
 */
public class Handlers {

    private static final String authString = PropertiesReader.getG() + ":" + PropertiesReader.getA();
    private static final String authStringEnc = new String(Base64.getEncoder().encode(authString.getBytes()));

    public static PartnerJson parserPartnerJson(String json) throws IOException {
        PartnerJson itemPartners = null;
        ObjectMapper om = new ObjectMapper() {
            {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }
        };
        itemPartners = om.readValue(json, PartnerJson.class);
        return itemPartners;
    }

    public static PartnersJson parserPartnerContact(String json) throws IOException {
        PartnersJson itemPartnersContact = null;
        ObjectMapper om = new ObjectMapper() {
            {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }
        };
        itemPartnersContact = om.readValue(json, PartnersJson.class);
        return itemPartnersContact;
    }



    public static HttpRequestBase setHeaderForAll(HttpRequestBase request) {
        request.setHeader(PropertiesReader.getAuth(), PropertiesReader.getBasic() + authStringEnc);
        request.addHeader(PropertiesReader.getContent(), PropertiesReader.getType());
        return request;
    }

    public static String JsonTransformer(String jsonSend) {
        jsonSend = jsonSend.replace("??", "\\u00F1").replace("??", "\\u00D1").replace("??", "\\u00C1").replace("??", "\\u00E1").replace("??", "\\u00C9").replace("??", "\\u00E9").replace("??", "\\u00CD").replace("??", "\\u00ED").replace("??", "\\u00D3").replace("??", "\\u00F3").replace("??", "\\u00DA").replace("??", "\\u00FA").replace("??", "\\u00DC").replace("??", "\\u00FC").replace("??", "\\u00F3").replace("??", "\\u00F1");
        return jsonSend;
    }

    public static String JsonTransformerESPECIAL(String jsonSend) {
        jsonSend = jsonSend.replace("??", "??").replace("??", "??");
        return jsonSend;
    }

    public static String JsonTransformerURI(String jsonSend) {
        jsonSend = jsonSend.replace("??", "%C3%B1").replace("??", "%C3%91").replace("??", "%C1").replace("??", "%C3%A1").replace("??", "%C3%89").replace("??", "%C3%A9").replace("??", "%C3%8D").replace("??", "%C3%AD").replace("??", "%C3%93").replace("??", "%C3%B3").replace("??", "%C3%9A").replace("??", "%C3%BA").replace("??", "%C3%9C").replace("??", "%C3%BC").replace("&", "%26").replace(" ", "%20").replace("-", "%2D");
        return jsonSend;
    }

    private static Map<Character, String> MAP_NORM;

    public static String stripDiacritics(String value) {
        if (MAP_NORM == null || MAP_NORM.isEmpty()) {
            MAP_NORM = new HashMap<>();
            MAP_NORM.put('!', "\\u0021");
            MAP_NORM.put('"', "\\u0022");
            MAP_NORM.put('#', "\\u0023");
            MAP_NORM.put('$', "\\u0024");
            MAP_NORM.put('%', "\\u0025");
            MAP_NORM.put('&', "\\u0026");
            MAP_NORM.put('(', "\\u0028");
            MAP_NORM.put(')', "\\u0029");
            MAP_NORM.put('*', "\\u002A");
            MAP_NORM.put('+', "\\u002B");
            MAP_NORM.put(',', "\\u002C");
            MAP_NORM.put('-', "\\u002D");
            MAP_NORM.put('.', "\\u002E");
            MAP_NORM.put('/', "\\u002F");
            MAP_NORM.put(':', "\\u003A");
            MAP_NORM.put(';', "\\u003B");
            MAP_NORM.put('<', "\\u003C");
            MAP_NORM.put('=', "\\u003D");
            MAP_NORM.put('>', "\\u003E");
            MAP_NORM.put('?', "\\u003F");
            MAP_NORM.put('@', "\\u0040");
            MAP_NORM.put('[', "\\u005B");
            MAP_NORM.put('\'', "\\u005C");
            MAP_NORM.put(']', "\\u005D");
            MAP_NORM.put('^', "\\u005E");
            MAP_NORM.put('_', "\\u005F");
            MAP_NORM.put('`', "\\u0060");
            MAP_NORM.put('{', "\\u007B");
            MAP_NORM.put('|', "\\u007C");
            MAP_NORM.put('}', "\\u007D");
            MAP_NORM.put('~', "\\u007E");
            MAP_NORM.put('??', "\\u00A1");
            MAP_NORM.put('??', "\\u00A2");
            MAP_NORM.put('??', "\\u00A3");
            MAP_NORM.put('??', "\\u00A4");
            MAP_NORM.put('??', "\\u00A5");
            MAP_NORM.put('??', "\\u00A6");
            MAP_NORM.put('??', "\\u00A7");
            MAP_NORM.put('??', "\\u00A8");
            MAP_NORM.put('??', "\\u00A9");
            MAP_NORM.put('??', "\\u00AA");
            MAP_NORM.put('??', "\\u00AB");
            MAP_NORM.put('??', "\\u00AC");
            MAP_NORM.put('??', "\\u00AE");
            MAP_NORM.put('??', "\\u00AF");
            MAP_NORM.put('??', "\\u00B0");
            MAP_NORM.put('??', "\\u00B1");
            MAP_NORM.put('??', "\\u00B2");
            MAP_NORM.put('??', "\\u00B3");
            MAP_NORM.put('??', "\\u00B4");
            MAP_NORM.put('??', "\\u00B5");
            MAP_NORM.put('??', "\\u00B6");
            MAP_NORM.put('??', "\\u00B7");
            MAP_NORM.put('??', "\\u00B8");
            MAP_NORM.put('??', "\\u00B9");
            MAP_NORM.put('??', "\\u00BA");
            MAP_NORM.put('??', "\\u00BB");
            MAP_NORM.put('??', "\\u00BC");
            MAP_NORM.put('??', "\\u00BD");
            MAP_NORM.put('??', "\\u00BE");
            MAP_NORM.put('??', "\\u00BF");
            MAP_NORM.put('??', "\\u00C0");
            MAP_NORM.put('??', "\\u00C1");
            MAP_NORM.put('??', "\\u00C2");
            MAP_NORM.put('??', "\\u00C3");
            MAP_NORM.put('??', "\\u00C4");
            MAP_NORM.put('??', "\\u00C5");
            MAP_NORM.put('??', "\\u00C6");
            MAP_NORM.put('??', "\\u00C7");
            MAP_NORM.put('??', "\\u00C8");
            MAP_NORM.put('??', "\\u00C9");
            MAP_NORM.put('??', "\\u00CA");
            MAP_NORM.put('??', "\\u00CB");
            MAP_NORM.put('??', "\\u00CC");
            MAP_NORM.put('??', "\\u00CD");
            MAP_NORM.put('??', "\\u00CE");
            MAP_NORM.put('??', "\\u00CF");
            MAP_NORM.put('??', "\\u00D0");
            MAP_NORM.put('??', "\\u00D1");
            MAP_NORM.put('??', "\\u00D2");
            MAP_NORM.put('??', "\\u00D3");
            MAP_NORM.put('??', "\\u00D4");
            MAP_NORM.put('??', "\\u00D5");
            MAP_NORM.put('??', "\\u00D6");
            MAP_NORM.put('??', "\\u00D7");
            MAP_NORM.put('??', "\\u00D8");
            MAP_NORM.put('??', "\\u00D9");
            MAP_NORM.put('??', "\\u00DA");
            MAP_NORM.put('??', "\\u00DB");
            MAP_NORM.put('??', "\\u00DC");
            MAP_NORM.put('??', "\\u00DD");
            MAP_NORM.put('??', "\\u00DE");
            MAP_NORM.put('??', "\\u00DF");
            MAP_NORM.put('??', "\\u00E0");
            MAP_NORM.put('??', "\\u00E1");
            MAP_NORM.put('??', "\\u00E2");
            MAP_NORM.put('??', "\\u00E3");
            MAP_NORM.put('??', "\\u00E4");
            MAP_NORM.put('??', "\\u00E5");
            MAP_NORM.put('??', "\\u00E6");
            MAP_NORM.put('??', "\\u00E7");
            MAP_NORM.put('??', "\\u00E8");
            MAP_NORM.put('??', "\\u00E9");
            MAP_NORM.put('??', "\\u00EA");
            MAP_NORM.put('??', "\\u00EB");
            MAP_NORM.put('??', "\\u00EC");
            MAP_NORM.put('??', "\\u00ED");
            MAP_NORM.put('??', "\\u00EE");
            MAP_NORM.put('??', "\\u00EF");
            MAP_NORM.put('??', "\\u00F0");
            MAP_NORM.put('??', "\\u00F1");
            MAP_NORM.put('??', "\\u00F2");
            MAP_NORM.put('??', "\\u00F3");
            MAP_NORM.put('??', "\\u00F4");
            MAP_NORM.put('??', "\\u00F5");
            MAP_NORM.put('??', "\\u00F6");
            MAP_NORM.put('??', "\\u00F7");
            MAP_NORM.put('??', "\\u00F8");
            MAP_NORM.put('??', "\\u00F9");
            MAP_NORM.put('??', "\\u00FA");
            MAP_NORM.put('??', "\\u00FB");
            MAP_NORM.put('??', "\\u00FC");
            MAP_NORM.put('??', "\\u00FD");
            MAP_NORM.put('??', "\\u00FE");
            MAP_NORM.put('??', "\\u00FF");
        }
        if (value == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(value);
        for (int i = 0; i < value.length(); i++) {
            String c = MAP_NORM.get(sb.charAt(i));
            if (c != null) {
                sb.setCharAt(i, sb.charAt(i));
            }
        }
        return sb.toString();
    }

}
