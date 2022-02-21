/* Copyright 2020 Beijing Calorie Information Technology Co. Ltd. */
/* 版权所有 2020 北京卡路里信息技术有限公司 */
package com.zhangkai.demo.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * KafkaController
 *
 * @author zhangkai
 * @date 2022/2/21 5:09 下午
 * @since 1.0.0
 */
@Controller
@RequestMapping("/api/kafka/")
public class KafkaController {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("send")
    @ResponseBody
    public boolean send(@RequestParam String message) {
        try {
            kafkaTemplate.send("zhangkai_send_test", message);
            System.out.println("消息发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
