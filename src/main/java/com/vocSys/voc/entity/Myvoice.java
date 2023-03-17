package com.vocSys.voc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.lang.reflect.Field;

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
@ApiModel(value = "Myvoice对象", description = "")
public class Myvoice implements Serializable {

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
            field = this.getClass().getField(x);
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
}
