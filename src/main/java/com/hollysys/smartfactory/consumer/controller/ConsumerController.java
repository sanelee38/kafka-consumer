package com.hollysys.smartfactory.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.hollysys.smartfactory.consumer.entity.Consumer;
import com.hollysys.smartfactory.consumer.entity.Producer;
import com.hollysys.smartfactory.consumer.entity.resp.ResultStatus;
import com.hollysys.smartfactory.consumer.service.ConsumerService;
import org.apache.ibatis.logging.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : lizhi
 * @Date : Created in 2021/9/28 11:06
 * @Description :
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/index")
    public String index(){
        return "helloword";
    }

    @GetMapping("/All")
    public List<Consumer> findAll(){
        return consumerService.queryAll();
    }

    @KafkaListener(topics={"kafka-topic"})
    public void onMessage(@RequestBody ConsumerRecord<?,?> record){
        System.out.println("收到消息");
        System.out.println(record.value().toString());
        ResultStatus resultStatus = JSON.parseObject(record.value().toString(), ResultStatus.class);
        String message = resultStatus.getMessage();
        List producers = JSON.parseObject(resultStatus.getData().toString(), List.class);
        List<Consumer> consumerList = new ArrayList<>();
        for (int i=0;i<producers.size();i++){
            consumerList.add(JSON.parseObject(producers.get(i).toString(),Consumer.class));
        }
        Consumer consumer = new Consumer();
        consumer.setId(consumerList.get(0).getId());
        consumer.setName(consumerList.get(0).getName());
        consumer.setItem(consumerList.get(0).getItem());
        switch (message){
            case "add":
                consumerService.insert(consumer);
                break;
            case "update":
                consumerService.update(consumer);
                break;
            case "delete":
                consumerService.deleteByName(consumer);
                break;
            case "deleteById":
                consumerService.deleteById(consumer.getId());
                break;
            case "insertBatch":
                consumerService.insertBatch(consumerList);
                break;
            default:
                log.info("未定义的message");
                System.out.println("未定义的message");
        }

        log.info("简单消费，record："+record.topic()+"-"+record.partition()+"-"+record.value());
        System.out.println("简单消费，record："+record.topic()+"-"+record.partition()+"-"+record.value());
    }

}
