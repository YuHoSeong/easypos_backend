package com.pcpos.easypos.service;

import com.pcpos.easypos.dto.request.user.PatchUserDto;
import com.pcpos.easypos.dto.response.ResponseDto;
import com.pcpos.easypos.dto.response.user.DeleteUserResponseDto;
import com.pcpos.easypos.dto.response.user.GetUserResponseDto;
import com.pcpos.easypos.dto.response.user.PatchUserResponseDto;

public interface UserService {
    // 관리자 정보 조회
    public ResponseDto<GetUserResponseDto> getUser(String email);
    // 관리자 정보 수정
    public ResponseDto<PatchUserResponseDto> patchUser(String email, PatchUserDto dto);
    // 회원 탈퇴
    public ResponseDto<DeleteUserResponseDto> deleteUser(String email);
    
}
