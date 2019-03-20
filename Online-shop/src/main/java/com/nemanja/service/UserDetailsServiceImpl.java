package com.nemanja.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nemanja.dao.UserDao;
import com.nemanja.entity.CustomUserDetail;
import com.nemanja.entity.User;
import com.nemanja.entity.UserRole;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDao userdao;
	
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    User user = userdao.findByUsername(username);
	    if (user == null)
	        throw new UsernameNotFoundException("username " + username
	                + " not found");
	    Set<UserRole> roles = user.getUserRole();
	    
	    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(UserRole role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }
         
	    CustomUserDetail customUserDetail=new CustomUserDetail();
        customUserDetail.setUser(user);
        customUserDetail.setAuthorities(authorities);

        return customUserDetail;
    }
}
