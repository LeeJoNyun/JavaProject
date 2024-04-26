package com.practice.toyproject.JoinController;

import com.practice.toyproject.dto.JoinDTO;
import com.practice.toyproject.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class JoinController {

    private final JoinService _joinService;

    public JoinController(JoinService joinService) {
        _joinService = joinService;
    }
    @PostMapping("/join")
    public String joinProcess(JoinDTO dto){
        _joinService.joinProcess(dto);
        return "ok";
    }
}
