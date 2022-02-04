package com.cos.photogramstart.config.auth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;


/*
* 스프링 시큐리티가 로그인 요청을 가로채 로그인을 진행하고 완료 되면 UserDetails 타입의 오브젝트를
* 스프링 시큐리티의 고유한 세션저장소에 저장 해준다.
* */


@Data
@AllArgsConstructor
public class PrincipalDetails implements UserDetails {

    private User user;

    @Override
    public String getPassword() { return user.getUserpw(); }

    @Override
    public String getUsername() { return user.getUserid(); }

    /* 계정 만료 여부
     *  true : 만료 안됨
     *  false : 만료
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* 계정 잠김 여부
     *  true : 잠기지 않음
     *  false : 잠김
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /* 비밀번호 만료 여부
     *  true : 만료 안됨
     *  false : 만료
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* 사용자 활성화 여부
    *  true : 만료 안됨
    *  false : 만료
    */
    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}




}

/*
@Data
public class PrincipalDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	private Map<String, Object> attributes;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
	}


	@Override
	public String getPassword() {
		return user.getUserpw();
	}

	@Override
	public String getUsername() {
		return user.getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;  // {id:343434343, name:최주호, email:ssarmango@nate.com}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return (String) attributes.get("username");
	}
}

*/
