package com.secondhandcar.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Created by xiet on 2017/10/12.
 */
@Controller
@RequestMapping("/secondHandcarType")
@Slf4j
public class SecondHandCarTypeController {

    @RequestMapping("")
    @ResponseBody
    public void index() {
        log.info("this is secondHandcarType");
    }
}
