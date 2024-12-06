package com.spring.learn.CouldVendorRestAPIService.mapper;

import com.spring.learn.CouldVendorRestAPIService.dto.CloudVendorDTO;
import com.spring.learn.CouldVendorRestAPIService.entity.CloudVendor;

public class CloudVendorMapper {
	
	public static CloudVendor mapToCloudVendor(CloudVendorDTO cloudVendorDto) {
		CloudVendor cloudVendor = new CloudVendor(cloudVendorDto.getCloudId(), cloudVendorDto.getCloudName(),
				cloudVendorDto.getCloudAddress(), cloudVendorDto.getCloudPhoneNumber());
		return cloudVendor;
	}

	public static CloudVendorDTO mapToCloudVendorDTO(CloudVendor cloudVendor) {
		CloudVendorDTO cloudVendorDto = new CloudVendorDTO(cloudVendor.getCloudId(), cloudVendor.getCloudName(),
				cloudVendor.getCloudAddress(), cloudVendor.getCloudPhoneNumber());
		return cloudVendorDto;
	}
}
