package com.spring.learn.CouldVendorRestAPIService.service;

import java.util.List;

import com.spring.learn.CouldVendorRestAPIService.dto.CloudVendorDTO;

public interface CloudAPIService {
	
	public CloudVendorDTO getVendorDetails(String vendorId);

	public String createCloudVendorDetails(CloudVendorDTO cloudVendorDto);

	public String updateVendorDetails(String vendorId, CloudVendorDTO cloudVendorDto);

	public List<CloudVendorDTO> getAllVendorDetails();

	public String deleteVendorDetails(String vendorId);
	
}
