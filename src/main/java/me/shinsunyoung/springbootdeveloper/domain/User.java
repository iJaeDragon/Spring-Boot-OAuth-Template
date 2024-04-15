package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "TB_MEMBERS_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MB_NO", updatable = false)
    private Long id;

    @Column(name = "MB_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "MB_NM")
    private String mbNm;

    @Column(name = "MB_BIRTH_DATE")
    private String mbBirthDate;

    @Column(name = "MB_GENDER")
    private String mbGender;

    @Column(name = "MB_PHONE_NUMBER")
    private String mbPhoneNumber;

    @Column(name = "MB_REGISTER_DATE")
    private String mbRegisterDate;

    @Column(name = "MB_REGISTER_IP")
    private String mbRegisterIp;

    @Column(name = "MB_UPDATE_DATE")
    private String mbUpdateDate;

    @Column(name = "MB_UPDATE_IP")
    private String mbUpdateIp;

    @Builder
    public User(Long id, String email, String nickname, String mbBirthDate, String mbGender, String mbPhoneNumber, String mbRegisterDate, String mbRegisterIp, String mbUpdateDate, String mbUpdateIp) {
        this.id = id;
        this.email = email;
        this.mbNm = nickname;
        this.mbBirthDate = mbBirthDate;
        this.mbGender = mbGender;
        this.mbPhoneNumber = mbPhoneNumber;
        this.mbRegisterDate = mbRegisterDate;
        this.mbRegisterIp = "1.1.1.1";
        this.mbUpdateDate = mbUpdateDate;
        this.mbUpdateIp = "1.1.1.1";
    }

    public User update(String nickname) {
        this.mbNm = nickname;

        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return "";
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
}