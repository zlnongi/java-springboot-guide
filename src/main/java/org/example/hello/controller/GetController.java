package org.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    // 만약 @GetMapping 어노테이션에 지정한 변수의 이름과 메서드 매개변수의 이름을 동일하게 맞추기 어렵다면
    // @PathVariable 뒤에 괄호를 열어 @GetMapping 어노테이션의 변수명을 지정
    @GetMapping(value = "/variable2/{variable}")
    public String getvariable2(@PathVariable("variable") String var) {
       return var;
    }

    // 쿼리 형식으로 값을 전달하기
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
     return name + " " + email + " " + organization;
    }

    // 쿼리스트링에 어떤 값이 들어올지 모르는 상태 -> Map 객체를 활용
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();

    }

}
