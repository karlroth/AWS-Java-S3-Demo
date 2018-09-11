package com.yash.aws.s3demo;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


/**
 * Hello world!
 *
 */
public class CreateBucketApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//Set credentials
		AWSCredentials credentials = new BasicAWSCredentials(
				"<AWS Access Key>",
				"<AWS Secret Key>");

		//Create client
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_1)
				.build();

		//Create bucket
		String bucketName = "karlroth-bucket";
		if (s3client.doesBucketExist(bucketName)) {
			System.out.println("Bucket name is not available." + " Try again with a different Bucket name.");
			return;
		} else {
			s3client.createBucket(bucketName);
			System.out.println("Bucket created successfully!");
		}
		
	}

}
