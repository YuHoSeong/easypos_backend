package com.pcpos.easypos.servicetest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pcpos.easypos.dto.request.auth.PostSignInDto;
import com.pcpos.easypos.dto.request.auth.PostSignUpDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.auth.PostSignUpResponseDto;
import com.pcpos.easypos.entity.UserEntity;
import com.pcpos.easypos.repository.UserRepository;
import com.pcpos.easypos.service.implementation.AuthServiceimpl;

@ExtendWith(MockitoExtension.class)
public class AuthServiceimplTest {
    @InjectMocks
    private AuthServiceimpl authService;

    @Mock
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @BeforeEach
    public void setUp() {
        // Mock 객체 초기화
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName(value = "회원가입 테스트")
    public void SignUpTest() {
        //given
        PostSignUpDto dto = new PostSignUpDto("test@example.com", "password", "name");
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encodedPassword);
        UserEntity userEntity = new UserEntity(dto);
        
        // stub
        BDDMockito.given(userRepository.existsByEmail(dto.getEmail()))
        .willReturn(false);
        BDDMockito.given(userRepository.save(Mockito.any(UserEntity.class))).willReturn(userEntity);

        // when
        ResponseDto<PostSignUpResponseDto> response = authService.postSignUp(dto);

        // then
        Assertions.assertThat(response.getData().isStatus()).isEqualTo(true);
    }

    @Test
    @DisplayName(value = "로그인 테스트")
    public void SignInTest(){
        // given
        PostSignInDto dto = new PostSignInDto("test@example.com", "password");
    }

}
