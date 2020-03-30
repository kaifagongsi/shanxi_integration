package com.kfgs.domain.ext;


import lombok.Data;

/**

 * Description: 上传图片返回信息 CKEditor需要返回json信息
 * uploaded 在上传成功时可以设置为1 失败为 0
 * fileName 为文件名
 * url 为文件的实际访问路径
 */
@Data
public class ImageUploadVo {
    private int uploaded;
    private String fileName;
    private String url;


    public int getUploaded() {
        return uploaded;
    }

    public void setUploaded(int uploaded) {
        this.uploaded = uploaded;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
