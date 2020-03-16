package com.dxs.fms.vo;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:13
 */
public class UpdateFileVo {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "UpdateFileVo{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
