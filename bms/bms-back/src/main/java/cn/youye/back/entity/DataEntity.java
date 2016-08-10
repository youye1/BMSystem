package cn.youye.back.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

/**
 * Created by pc on 2016/8/10.
 */
public class DataEntity {
    private static Logger logger = LoggerFactory.getLogger(DataEntity.class);

    private static final long serialVersionUID = 1L;
    @JSONField(serialize = false)
    private String id;              //实体编号
    @JSONField(serialize = false)
    private Date createDate;        //创建日期
    @JSONField(serialize = false)
    private Date updateDate;        //更新日期
    @JSONField(serialize = false)
    private String createBy;        //创建者
    @JSONField(serialize = false)
    private String updateBy;        //更新者
    @JSONField(serialize = false)
    private String delFlag;         //删除标记

    public DataEntity() {
        delFlag=DEL_FLAG_NORMAL;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";

}
