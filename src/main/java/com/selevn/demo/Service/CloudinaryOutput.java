package com.selevn.demo.Service;

public class CloudinaryOutput {
    String cloudinary_id;
    String url;

    public String getCloudinary_id() {
        return cloudinary_id;
    }

    public String getUrl() {
        return url;
    }

    public CloudinaryOutput(String cloudinary_id, String url) {
        this.cloudinary_id = cloudinary_id;
        this.url = url;
    }
}
