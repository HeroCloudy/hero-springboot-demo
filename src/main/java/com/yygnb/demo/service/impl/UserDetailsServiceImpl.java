package com.yygnb.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yygnb.demo.entity.User;
import com.yygnb.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: com.yygnb.demo.service.impl.HeroUserDetailsService
 * @Description: <h1></h1>
 * @Date: 2022/8/25 19:05
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/25 19:05   dscloudy    Create File.
 */
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //    @Autowired
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = this.userMapper.selectOne(wrapper);
        if (user == null) {
            throw new UsernameNotFoundException("根据用户名未查询到用户");
        }

        // 模拟查询权限
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), passwordEncoder.encode(user.getPassword()), authorities);
    }
}
