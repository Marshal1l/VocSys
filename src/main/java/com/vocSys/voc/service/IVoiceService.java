package com.vocSys.voc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vocSys.voc.common.Result;
import com.vocSys.voc.entity.Voice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author VocSys
 * @since 2023-03-14
 */
public interface IVoiceService extends IService<Voice> {
    public Result showVoc(Integer currentPage, Integer pageNum, String problem,
                          String proclass, String protype, String search);
    public Result getVoc(Integer id);
    public Page<Voice> getAllVoc(Integer currentPage, Integer pageNum);
    public  Result  getPrecision();
}
