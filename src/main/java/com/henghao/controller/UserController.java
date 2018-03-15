package com.henghao.controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henghao.model.User;
import com.henghao.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 插入一条数据
     * @param json
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody String json)  {
        try {
            User user = JSON.parseObject(json, User.class);
            this.userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserById(@PathVariable long id) {
        try {
            this.userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //500
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 修改数据
     * @param json
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public  ResponseEntity<Void> updateUserEntity(@RequestBody String json) {
        try {
            User user = JSON.parseObject(json, User.class);
            this.userService.updateUserEntiyty(user);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //500
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    /**
     * 根据id查找
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<User> queryObjTest(@PathVariable long id) {
      try {
          User user = (User) this.userService.queryObjTest(id);
          if(user == null) {
              ResponseEntity<Object> body = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
          }
          return ResponseEntity.status(HttpStatus.OK).body(user);
      }catch (Exception e) {
          e.printStackTrace();
      }
        //500
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * http形式返回
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    /**
     * 查询所有
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<User>  queryUserAll(HttpServletRequest request, HttpServletResponse response) {
        return  this.userService.queryUserAll();

    }


}