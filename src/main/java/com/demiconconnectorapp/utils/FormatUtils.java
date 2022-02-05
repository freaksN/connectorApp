package com.demiconconnectorapp.utils;

import com.demiconconnectorapp.models.RandomUser;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class FormatUtils {

    /**
     * formats the json response based on the given specifications
     *
     * @param users
     * @param items
     */
    public static void formatJsonResponse(List<RandomUser> users, List<Map<String, Object>> items) {
        for (RandomUser user : users) {
            Map<String, Object> item = newHashMap();
            Map<String, Object> userInfo = newHashMap();
            item.put("name", user.getLocation().getCountry());
            userInfo.put("name", user.getName().getFirst() + " " + user.getName().getLast());
            userInfo.put("gender", user.getGender());
            userInfo.put("email", user.getEmail());
            item.put("user", userInfo);
            items.add(item);
        }
    }
}
