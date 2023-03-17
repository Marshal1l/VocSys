package com.vocSys.voc.controller;

import com.vocSys.voc.common.Result;
import com.vocSys.voc.entity.Myvoice;
import com.vocSys.voc.entity.Newvoice;
import com.vocSys.voc.entity.Voice;
import com.vocSys.voc.service.IMyvoiceService;
import com.vocSys.voc.service.IVoiceService;
import com.vocSys.voc.service.impl.VoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author VoiceSys
 * @since 2023-03-14
 */
@RestController
@RequestMapping("/voc")
public class VoiceController {

    @Autowired
    private IVoiceService voiceService;
    @Autowired
    private IMyvoiceService myvoiceService;

    @RequestMapping("/getallvoc")
    public Result getAllVoc(@RequestParam(value = "currentpage") Integer currentPage,
                            @RequestParam(value = "pagenum") Integer pageNum) {
        List<Voice> voiceList = voiceService.getAllVoc(currentPage, pageNum).getRecords();
        List<Myvoice> myvoiceList = myvoiceService.getAllVoc(currentPage, pageNum).getRecords();
        List<Newvoice> newvoices = new ArrayList<>(voiceList.size());
        for (int i = 0; i < voiceList.size(); i++) {
            newvoices.add(new Newvoice(voiceList.get(i),myvoiceList.get(i)));
        }
        return Result.success("200", String.valueOf(voiceService.getAllVoc(currentPage,pageNum).getTotal()), newvoices);
    }

    @RequestMapping("/showvoc")
    public Result showVoice(@RequestParam(value = "currentpage") Integer currentPage,
                            @RequestParam(value = "pagenum") Integer pageNum,
                            @RequestParam(value = "problem") String problem,
                            @RequestParam(value = "proclass") String proclass,
                            @RequestParam(value = "protype") String protype,
                            @RequestParam(value = "what") String search) {
        return voiceService.showVoc(currentPage, pageNum, problem, proclass, protype, search);
    }
    @RequestMapping("/getprecision")
    public Result getPrecision(){
        return voiceService.getPrecision();
    }
}

