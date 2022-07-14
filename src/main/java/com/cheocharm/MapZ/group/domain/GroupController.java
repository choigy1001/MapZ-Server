package com.cheocharm.MapZ.group.domain;

import com.cheocharm.MapZ.common.CommonResponse;
import com.cheocharm.MapZ.group.domain.dto.ChangeGroupStatusDto;
import com.cheocharm.MapZ.group.domain.dto.CreateGroupDto;
import com.cheocharm.MapZ.group.domain.dto.GetGroupListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "GroupController")
@RequiredArgsConstructor
@RequestMapping("/api/group")
@RestController
public class GroupController {

    private final GroupService groupService;

    @Operation(description = "그룹 생성")
    @Parameter(name = "accessToken", in = ParameterIn.HEADER, required = true)
    @PostMapping
    public CommonResponse<?> createGroup(@RequestBody @Valid CreateGroupDto createGroupDto) {
        groupService.createGroup(createGroupDto);
        return CommonResponse.success();
    }

    @Operation(description = "그룹 선택을 위한 그룹 조회")
    @Parameter(name = "accessToken", in = ParameterIn.HEADER, required = true)
    @GetMapping
    public CommonResponse<List<GetGroupListDto>> getGroup() {
        return CommonResponse.success(groupService.getGroup());
    }

    @Operation(description = "그룹 공개여부 변경")
    @Parameter(name = "accessToken", in = ParameterIn.HEADER, required = true)
    @PatchMapping("/status")
    public CommonResponse<?> changeGroupStatus(@RequestBody @Valid ChangeGroupStatusDto changeGroupStatusDto) {
        groupService.changeGroupStatus(changeGroupStatusDto);
        return CommonResponse.success();
    }
}
