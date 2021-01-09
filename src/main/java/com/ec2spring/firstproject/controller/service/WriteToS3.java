/**
 *
 */
package com.ec2spring.firstproject.controller.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author sushim
 *
 */
@Service
public class WriteToS3 {

    public void createBucketAndPutObject() {
        try {
            String bucketName = "firstbktsushimaws2020a";
            Regions region = Regions.US_EAST_2;
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(region).build();
            s3Client.createBucket(new CreateBucketRequest(bucketName));
            System.out.println("Bucket Location" + s3Client.getBucketLocation(new GetBucketLocationRequest(bucketName)));
            PutObjectRequest objectRequest = new PutObjectRequest(bucketName, "firstFile", new File("firstfile.txt"));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("title", "sometitle");
            objectRequest.setMetadata(metadata);
            s3Client.putObject(objectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
