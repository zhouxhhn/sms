package cn.siyue.platform.sms.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 短信表
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@ApiModel(value = "短信操作(SiyueSms)")
@Data
@TableName("siyue_sms")
public class SiyueSms extends Model<SiyueSms> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主健id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String cellphone;
    /**
     * 发送内容
     */
    @ApiModelProperty(value = "发送内容")
    private String content;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_at")
    private Date createAt = new Date();


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
