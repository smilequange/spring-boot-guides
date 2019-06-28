package cn.jantd.springsecurity.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class RoleService {

    public Map<String, Set<String>> getUriRoleCollection() {
        Map<String,Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add("role");
        map.put("/test",set);
        return map;//todo
    }

}
