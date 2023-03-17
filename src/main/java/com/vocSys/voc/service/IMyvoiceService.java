package com.vocSys.voc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vocSys.voc.common.Result;
import com.vocSys.voc.entity.Myvoice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author VocSys
 * @since 2023-03-14
 */
public interface IMyvoiceService extends IService<Myvoice> {
    public Page<Myvoice> getAllVoc(Integer currentPage, Integer pageNum);
}
