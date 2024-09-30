package org.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/v1/get-api")
public class GetController {
   @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String gethello() {
       return "Hello World";
   }
   // 매개변수 없는 GET 메서드 구현
   @GetMapping(value = "/name")
    public String getname() {
       return "Flature";
   }

   // 실무 환경에서 매개변수를 받지 않는 메서드 거의 쓰이지 않음
    // URL 자체에 값을 담아 요청하는 것
    @GetMapping(value ="/variable1/{variable}")
    public String getvariable1(@PathVariable String variable) {
       return variable;
    }
}
