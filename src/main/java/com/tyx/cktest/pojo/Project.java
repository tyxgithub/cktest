package com.tyx.cktest.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tyx
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Project对象", description="")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "接口项目名")
    private String name;

    @ApiModelProperty(value = "接口项目的主机地址")
    private String host;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建用户id")
    private Integer createUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
