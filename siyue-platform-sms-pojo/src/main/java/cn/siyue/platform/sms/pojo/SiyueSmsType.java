package cn.siyue.platform.sms.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 短信类型表
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@ApiModel(value = "短信类型操作(SiyueSms)")
@Data
@Accessors(chain = true)
@TableName("siyue_sms_type")
public class SiyueSmsType extends Model<SiyueSmsType> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主健id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 平台code
     */
    @ApiModelProperty(value = "平台code:斯越里(siyueli)",required = true)
    private String platform;

    /**
     * 平台名
     */
    @ApiModelProperty(value = "平台名")
    private String name;

    /**
     * 短信内容
     */
    @ApiModelProperty(value = "短信内容")
    private String content;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型:0:验证码",required = true)
    private Integer type;

    /**
     * 手机号
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "手机号",required = true)
    private String cellphone;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_at")
    private Date createAt;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
