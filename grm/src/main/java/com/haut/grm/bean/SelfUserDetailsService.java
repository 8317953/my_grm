//package com.haut.grm.bean;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class SelfUserDetailsService implements UserDetailsService  {
//
//	@Autowired
//    private UserMapper userMapper;
// 
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// 
//        //通过username查询用户
//        SelfUserDetails user = userMapper.getUser(username);
//        if(user == null){
//            //仍需要细化处理
//            throw new UsernameNotFoundException("该用户不存在");
//        }
// 
//        Set authoritiesSet = new HashSet();
//        // 模拟从数据库中获取用户角色
//        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
// 
//        authoritiesSet.add(authority);
//        user.setAuthorities(authoritiesSet);
// 
//        log.info("用户{}验证通过",username);
//        return user;
//    }
//
//}
