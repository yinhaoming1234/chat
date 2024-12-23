package com.aigoverse.channel.service;

import com.aigoverse.channel.mapper.ChannelMapper;
import com.aigoverse.channel.mapper.ChannelToModelMapper;
import com.aigoverse.channel.mapper.ModelMapper;
import com.aigoverse.channel.pojo.Channel;
import com.aigoverse.channel.pojo.ChannelToModel;
import com.aigoverse.channel.pojo.Proxy;
import com.aigoverse.channel.pojo.vo.ChannelVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService  {
    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ChannelToModelMapper channelToModelMapper;

    //补充group
    public List<ChannelVO> list() {
        List<Channel> channels = channelMapper.selectList(new QueryWrapper<Channel>());
        List<ChannelVO> channelVOs = new ArrayList<>();
        for (Channel channel : channels) {
            ChannelVO channelVO = new ChannelVO();
            channelVO.setId(channel.getId());
            channelVO.setName(channel.getName());
            channelVO.setType(channel.getType());
            channelVO.setPriority(channel.getPriority());
            channelVO.setWeight(channel.getWeight());
            channelVO.setRetry(channel.getRetry());
            channelVO.setSecret(channel.getSecret());
            channelVO.setEndpoint(channel.getEndpoint());
            channelVO.setMapper(channel.getMapper());
            channelVO.setState(channel.getState());
            Proxy proxy = new Proxy();
            proxy.setProxy(channel.getProxy());
            proxy.setProxy_type(channel.getProxy_type());
            proxy.setUsername(channel.getUsername());
            proxy.setPassword(channel.getPassword());
            modelMapper.selectListByChannelId(channel.getId()).forEach(model -> {
                channelVO.getModels().add(model.getName());
            });



            channelVO.setProxy(proxy);
            channelVOs.add(channelVO);
        }
        return channelVOs;

    }

    public ChannelVO get(Long id) {
        Channel channel = channelMapper.selectById(id);
        ChannelVO channelVO = new ChannelVO();
        channelVO.setId(channel.getId());
        channelVO.setName(channel.getName());
        channelVO.setType(channel.getType());
        channelVO.setPriority(channel.getPriority());
        channelVO.setWeight(channel.getWeight());
        channelVO.setRetry(channel.getRetry());
        channelVO.setSecret(channel.getSecret());
        channelVO.setEndpoint(channel.getEndpoint());
        channelVO.setMapper(channel.getMapper());
        channelVO.setState(channel.getState());
        Proxy proxy = new Proxy();
        proxy.setProxy(channel.getProxy());
        proxy.setProxy_type(channel.getProxy_type());
        proxy.setUsername(channel.getUsername());
        proxy.setPassword(channel.getPassword());
        modelMapper.selectListByChannelId(channel.getId()).forEach(model -> {
            channelVO.getModels().add(model.getName());
        });
        channelVO.setProxy(proxy);
        return channelVO;

    }

    public ChannelVO create(ChannelVO channelVO) {
        Channel channel = new Channel();
        channel.setName(channelVO.getName());
        channel.setType(channelVO.getType());
        channel.setPriority(channelVO.getPriority());
        channel.setWeight(channelVO.getWeight());
        channel.setRetry(channelVO.getRetry());
        channel.setSecret(channelVO.getSecret());
        channel.setEndpoint(channelVO.getEndpoint());
        channel.setMapper(channelVO.getMapper());
        channel.setState(channelVO.getState());
        channel.setProxy(channelVO.getProxy().getProxy());
        channel.setProxy_type(channelVO.getProxy().getProxy_type());
        channel.setUsername(channelVO.getProxy().getUsername());
        channel.setPassword(channelVO.getProxy().getPassword());
        List<String> models = channelVO.getModels();
        List<ChannelToModel> channelToModels = new ArrayList<>();
        for (String model : models) {
            ChannelToModel channelToModel = new ChannelToModel();
            channelToModel.setChannelId(channel.getId());
            channelToModel.setChannelId(modelMapper.selectOne(new QueryWrapper<com.aigoverse.channel.pojo.Model>().eq("name", model)).getId());
            channelToModels.add(channelToModel);
        }
        channelToModelMapper.insert(channelToModels);
        channelMapper.insert(channel);
        channelVO.setId(channel.getId());
        return channelVO;
    }

    public ChannelVO update(Long id, ChannelVO channelVO) {
        Channel channel = new Channel();
        channel.setId(id);
        channel.setName(channelVO.getName());
        channel.setType(channelVO.getType());
        channel.setPriority(channelVO.getPriority());
        channel.setWeight(channelVO.getWeight());
        channel.setRetry(channelVO.getRetry());
        channel.setSecret(channelVO.getSecret());
        channel.setEndpoint(channelVO.getEndpoint());
        channel.setMapper(channelVO.getMapper());
        channel.setState(channelVO.getState());
        channel.setProxy(channelVO.getProxy().getProxy());
        channel.setProxy_type(channelVO.getProxy().getProxy_type());
        channel.setUsername(channelVO.getProxy().getUsername());
        channel.setPassword(channelVO.getProxy().getPassword());
        List<String> models = channelVO.getModels();
        List<ChannelToModel> channelToModels = new ArrayList<>();
        for (String model : models) {
            ChannelToModel channelToModel = new ChannelToModel();
            channelToModel.setChannelId(channel.getId());
            channelToModels.add(channelToModel);
        }
        channelMapper.updateById(channel);
        return channelVO;
    }
}
