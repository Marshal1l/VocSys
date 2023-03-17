package com.vocSys.voc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.vocSys.voc.controller.VoiceController;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author VocSys
 * @since 2023-03-14
 */
@Getter
@Setter
@ApiModel(value = "Voice对象", description = "")
public class Voice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    public Object getwhat(String x){
        Field field= null;
        try {

            field = this.getClass().getDeclaredField(x);  field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        field.setAccessible(true);
        try {
            return field.get(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    static public List<String> getAttribute() {
        List<String> list = new ArrayList<>();
        list.add("belong");
        list.add("network");
        list.add("vocclass");
        list.add("level");
        list.add("toolclass");
        list.add("toolsubclass");
        list.add("toolfeature");
        list.add("productclass");
        list.add("productsubclass");
        list.add("datafeature");
        list.add("dataclass");
        list.add("problemclass");
        list.add("problemsubclass");
        return list;
    }
}
