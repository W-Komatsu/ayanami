package pers.wk.ayanami.business.controller;

import domain.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.wk.ayanami.business.domain.CreateUserReq;
import pers.wk.ayanami.business.service.UserService;

import javax.validation.Valid;

/**
 * @author wangxiaosong
 * @date 2020/4/16
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUserInfo")
    public ResponseEntity<CommonResponse> getUserInfo(@RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "currPage") int currPage,
                                                      @RequestParam(value = "pageSize") int pageSize){
        return ResponseEntity.ok(new CommonResponse(userService.getUserInfo(name, currPage, pageSize), null));
    }
    @PostMapping("/createUser")
    public ResponseEntity<CommonResponse> createUser(@RequestBody @Valid CreateUserReq req){
        userService.addUser(req);
        return ResponseEntity.ok(null);
    }
}
