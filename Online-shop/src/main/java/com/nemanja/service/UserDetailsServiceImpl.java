package com.nemanja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.nemanja.dao.UserDao;
import com.nemanja.entity.User;

//Temporary unused class...

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
	    
	    // [USER,ADMIN,..]
        List<String> roles= userdao.findUserRoleByUsername(username);
         
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
            }
        }        
         
        UserDetails userDetails = (UserDetails) new User(user.getUsername(), //
                user.getPassword(), user.getEmail());
 
        return userDetails;
    }
}
