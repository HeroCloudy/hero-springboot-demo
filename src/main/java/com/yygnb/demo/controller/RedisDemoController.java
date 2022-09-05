package com.yygnb.demo.controller;

import com.yygnb.demo.utils.RedisUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

/**
 * @Title: com.yygnb.demo.controller.RedisDemoController
 * @Description: <h1></h1>
 * @Date: 2022/9/5 16:13
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/9/5 16:13   dscloudy    Create File.
 */
@Tag(name = "Redis测试接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class RedisDemoController {

    private final RedisUtils redisUtils;

    @Operation(summary = "存值")
    @PostMapping()
    public void save(@RequestBody Map<String, Object> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            redisUtils.set(key, map.get(key));
        }
    }

    @Operation(summary = "取值")
    @GetMapping()
    public Object get(String key) {
        return redisUtils.get(key);
    }
}
