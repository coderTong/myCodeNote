# 目录

1. [AJAX](#)
2. [JSON](#)


# AJAX

1. 概念
2. 实现方式
# JSON


```java

package com.danmanshow.web.servlet;

import com.danmanshow.domain.MyUser;
import com.danmanshow.service.Imp.UserServiceImp;
import com.danmanshow.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/myFindUserServlet")
public class MyFindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        // 1. 获取用户名参数
  String userName = request.getParameter("userName");

        System.out.println("查找的"+userName);
        // 2. 查找    UserService service = new UserServiceImp();
        MyUser user = service.findUserInfoWithUserName(userName);
        System.out.println(user);

        Map<String, Object> map = new HashMap<String, Object>();

        if (user != null){
            map.put("userExsit", true);
            map.put("msg", "用户已存在,请重新填写");
        }else {
            map.put("userExsit", false);
            map.put("msg", "用户可用");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

```
