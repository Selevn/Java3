package com.selevn.demo.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class CloudinaryUploadService {

    private static CloudinaryUploadService instance;

    public static CloudinaryUploadService getInstance(){
        return Objects.requireNonNullElseGet(instance, () -> instance = new CloudinaryUploadService());
    }


    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "selevn",
            "api_key", "651245678742159",
            "api_secret", "SX30QtEk67tigzj0LOd9gsZn9FU",
            "secure", true));

    public CloudinaryOutput loadImage(String path) throws IOException {
        File file = new File(path);
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return new CloudinaryOutput(
                uploadResult.get("public_id").toString(),
                uploadResult.get("url").toString()
                );
    }
    public CloudinaryOutput updateImage(String path, String oldId) throws Exception {
        File file = new File(path);
        //Map deleted = cloudinary.uploader().deleteByToken(oldId);

        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();

        return new CloudinaryOutput(
                uploadResult.get("public_id").toString(),
                uploadResult.get("url").toString()
        );
    }
}