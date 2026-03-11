package org.ecom.productservice.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
public class S3Service {
    @Value("${aws.bucket-name}")
    private String bucketName;
    private final S3Client s3Client;

    S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String upload(MultipartFile file, String folder) throws IOException {
        String key = folder + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(file.getContentType())
                .build();
        s3Client.putObject(putObjectRequest,
                RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        return key;
    }
}
