package com.dxs.fms.dto;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:37
 */
public class FileDto {
    private String fileName;
    private String fileSuffix;
    private Integer creator;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "fileName='" + fileName + '\'' +
                ", fileSuffix='" + fileSuffix + '\'' +
                ", creator=" + creator +
                '}';
    }
}
