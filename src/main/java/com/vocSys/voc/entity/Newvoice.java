package com.vocSys.voc.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class Newvoice {
    private Integer id;

    private String productname;

    private String voc;

    private String response;

    private String belong;

    private String network;

    private String language;

    private String vocclass;

    private String level;

    private String toolclass;

    private String toolsubclass;

    private String toolfeature;

    private String productclass;

    private String productsubclass;

    private String datafeature;

    private String dataclass;

    private String problemclass;

    private String problemsubclass;
    private String newbelong;

    private String newnetwork;

    private String newlanguage;

    private String newvocclass;

    private String newlevel;

    private String newtoolclass;

    private String newtoolsubclass;

    private String newtoolfeature;

    private String newproductclass;

    private String newproductsubclass;

    private String newdatafeature;

    private String newdataclass;

    private String newproblemclass;

    private String newproblemsubclass;

    public Newvoice(Voice voice, Myvoice myvoice) {
        this.id = voice.getId();
        this.voc = voice.getVoc();
        this.response = voice.getResponse();
        this.belong = voice.getBelong();
        this.language = voice.getLanguage();
        this.network = voice.getNetwork();
        this.vocclass = voice.getVocclass();
        this.level = voice.getLevel();
        this.toolclass = voice.getToolclass();
        this.toolsubclass = voice.getToolsubclass();
        this.toolfeature = voice.getToolfeature();
        this.productclass = voice.getProductclass();
        this.productsubclass = voice.getProductsubclass();
        this.datafeature = voice.getDatafeature();
        this.dataclass = voice.getDataclass();
        this.problemclass = voice.getProblemclass();
        this.problemsubclass = voice.getProblemsubclass();
        this.newbelong = myvoice.getBelong();
        this.newlanguage = myvoice.getLanguage();
        this.newnetwork = myvoice.getNetwork();
        this.newvocclass = myvoice.getVocclass();
        this.newlevel = myvoice.getLevel();
        this.newtoolclass = myvoice.getToolclass();
        this.newtoolsubclass = myvoice.getToolsubclass();
        this.newtoolfeature = myvoice.getToolfeature();
        this.newproductclass = myvoice.getProductclass();
        this.newproductsubclass = myvoice.getProductsubclass();
        this.newdatafeature = myvoice.getDatafeature();
        this.newdataclass = myvoice.getDataclass();
        this.newproblemclass = myvoice.getProblemclass();
        this.newproblemsubclass = myvoice.getProblemsubclass();
    }
}

