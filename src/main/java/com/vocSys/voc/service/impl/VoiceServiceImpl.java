package com.vocSys.voc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vocSys.voc.common.Result;
import com.vocSys.voc.entity.Myvoice;
import com.vocSys.voc.entity.Voice;
import com.vocSys.voc.mapper.MyvoiceMapper;
import com.vocSys.voc.mapper.VoiceMapper;
import com.vocSys.voc.service.IVoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author VocSys
 * @since 2023-03-14
 */
@Service
public class VoiceServiceImpl extends ServiceImpl<VoiceMapper, Voice> implements IVoiceService {
    @Autowired
    public VoiceMapper voiceMapper;
    @Autowired
    public MyvoiceMapper myvoiceMapper;
    @Autowired
    public MyvoiceServiceImpl myvoiceService;

    @Override
    public Result showVoc(Integer currentPage, Integer pageNum, String vocclass, String belong,
                          String network, String search) {
        QueryWrapper<Voice> vocQueryWrapper = new QueryWrapper<>();
        System.out.println("page(" + currentPage + "," + pageNum + ")");
        if (vocclass == "") System.out.println("vocclass is null");
        else vocQueryWrapper.eq("vocclass", vocclass);
        if (search == "") System.out.println("search is null");
        else vocQueryWrapper.like("voc", search);
        if (belong == "") System.out.println("belong is null");
        else vocQueryWrapper.eq("belong", belong);
        if (network == "") System.out.println("network is null");
        else vocQueryWrapper.eq("network", network);
        Page<Voice> vocPage = voiceMapper.selectPage(new Page<>(currentPage, pageNum), vocQueryWrapper);
        return Result.success("200", "成功返回相关voc", vocPage);
    }

    @Override
    public Result getVoc(Integer id) {
        QueryWrapper<Voice> vocQueryWrapper = new QueryWrapper<>();
        vocQueryWrapper.eq("id", id);
        if (voiceMapper.selectList(vocQueryWrapper).size() != 0)
            return Result.success("200", "成功获取该VOC", voiceMapper.selectList(vocQueryWrapper).get(0));
        else
            return Result.error("400", "无该ID的VOC");
    }

    @Override
    public Page<Voice> getAllVoc(Integer currentPage, Integer pageNum) {
        QueryWrapper<Voice> vocQueryWrapper = new QueryWrapper<>();
        return voiceMapper.selectPage(new Page<>(currentPage, pageNum), vocQueryWrapper);
    }

    @Override
    public Result getPrecision() {
        Map<String, Float> map = new HashMap<>();
        QueryWrapper<Voice> vocQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Myvoice> myvoiceQueryWrapper = new QueryWrapper<>();
        List<Voice> voiceList = voiceMapper.selectList(vocQueryWrapper);
        List<Myvoice> myvoiceList = myvoiceMapper.selectList(myvoiceQueryWrapper);
        List<String> list = Voice.getAttribute();
        for (String attr : list) {
            int num = 0;
            int sum = voiceList.size();
            for (int i = 0; i < sum; i++) {
                if (voiceList.get(i).getwhat(attr) == myvoiceList.get(i).getwhat(attr))
                    ++num;
            }
            float precision = num / sum;
            map.put(attr, precision);
        }
        return Result.success("200","成功获得准确率",map);
    }
}
