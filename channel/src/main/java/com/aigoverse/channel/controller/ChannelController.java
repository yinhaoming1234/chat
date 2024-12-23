package com.aigoverse.channel.controller;

import com.aigoverse.channel.pojo.vo.ChannelVO;
import com.aigoverse.channel.service.ChannelService;
import com.aigoverse.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;
    @GetMapping("/list")
    public Result<List<ChannelVO>> list() {
        return Result.success(channelService.list());
    }
    @GetMapping("/get/{id}")
    public Result<ChannelVO> get(@PathVariable Long id) {
        return Result.success(channelService.get(id));
    }
    @PostMapping("/create")
    public Result<ChannelVO> create(@RequestBody ChannelVO channelVO) {

        return Result.success(channelService.create(channelVO));
    }
    @PostMapping("/update/{id}")
    public Result<ChannelVO> update(@PathVariable Long id, @RequestBody ChannelVO channelVO) {
        return Result.success(channelService.update(id, channelVO));
    }



}
