package com.yash.aws.s3demo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class ListBucketApp {

	public static void main(String[] args) {
		// Set credentials
		AWSCredentials credentials = new BasicAWSCredentials(
				"<AWS Access Key>",
				"<AWS Secret Key>");

		// Create client
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_1)
				.build();
		
		// List existing buckets
		for (Bucket bucket : s3client.listBuckets()) {
			System.out.println(bucket.getName());
		}
	}

}
