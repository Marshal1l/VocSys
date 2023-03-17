package com.vocSys.voc.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vocSys.voc.entity.Myvoice;
import com.vocSys.voc.mapper.MyvoiceMapper;
import com.vocSys.voc.service.IMyvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author VocSys
 * @since 2023-03-14
 */
@Service
public class MyvoiceServiceImpl extends ServiceImpl<MyvoiceMapper, Myvoice> implements IMyvoiceService {
    @Autowired
    public MyvoiceMapper myvoiceMapper;
    @Override
    public Page<Myvoice> getAllVoc(Integer currentPage, Integer pageNum) {
        QueryWrapper<Myvoice> vocQueryWrapper = new QueryWrapper<>();
        return  myvoiceMapper.selectPage(new Page<>(currentPage, pageNum), vocQueryWrapper);
    }
}
