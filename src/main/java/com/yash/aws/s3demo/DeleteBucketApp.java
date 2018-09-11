package com.yash.aws.s3demo;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class DeleteBucketApp {

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

		try {
			s3client.deleteBucket("karlroth-bucket");
			System.out.println("Sucessfully deleted!");
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			return;
		}

	}

}
