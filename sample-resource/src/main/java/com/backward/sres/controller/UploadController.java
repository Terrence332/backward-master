package com.backward.sres.controller;

import com.backward.common.api.BaseResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class UploadController {

    @ApiOperation(value = "文件上传测试")
    @PostMapping(value = "/upload")
    @PreAuthorize("hasAuthority('p1')")
    public BaseResponse handleFileUpload(@RequestParam(value = "file")MultipartFile file) throws IOException {
        log.info(String.valueOf(file.getSize()));
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);
        String path = fileToSave.getAbsolutePath();
        log.info(path);
        return BaseResponse.builder().message(path).build();
    }

}
