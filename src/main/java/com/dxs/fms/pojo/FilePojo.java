package com.dxs.fms.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/2/28 0028 20:39
 */
@Getter
@Setter
@ToString
public class FilePojo {
    /**
     * 文件id
     */
    private Integer fileId;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件的后缀格式
     */
    private String fileSuffix;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 文件是否删除（0未删除1删除）
     */
    private Integer del;
}
