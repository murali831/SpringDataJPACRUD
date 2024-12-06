package com.spring.learn.CouldVendorRestAPIService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.learn.CouldVendorRestAPIService.dto.CloudVendorDTO;
import com.spring.learn.CouldVendorRestAPIService.entity.CloudVendor;
import com.spring.learn.CouldVendorRestAPIService.exception.CloudVendorNotFoundException;
import com.spring.learn.CouldVendorRestAPIService.mapper.CloudVendorMapper;
import com.spring.learn.CouldVendorRestAPIService.repository.CloudAPIRepo;

@Service
public class CloudAPIServiceImpl implements CloudAPIService {
	
	@Autowired
	CloudAPIRepo cloudAPIRepo;


	@Override
	public CloudVendorDTO getVendorDetails(String vendorId) {
		CloudVendor cloudVendor = cloudAPIRepo.findById(vendorId)
				.orElseThrow(() -> new CloudVendorNotFoundException("Vendor details not Found"));
		CloudVendorDTO cloudVendorDTO = CloudVendorMapper.mapToCloudVendorDTO(cloudVendor);
		return cloudVendorDTO;
	}

	@Override
	public String createCloudVendorDetails(CloudVendorDTO cloudVendorDto) {
		CloudVendor cloudVendor = CloudVendorMapper.mapToCloudVendor(cloudVendorDto);
		cloudAPIRepo.save(cloudVendor);
		return "SUCCESS";
	}

	@Override
	public String updateVendorDetails(String vendorId, CloudVendorDTO cloudVendorDto) {
		CloudVendor cloudVendor = cloudAPIRepo.findById(vendorId)
				.orElseThrow(() -> new CloudVendorNotFoundException("Vendor details not Found"));
			//cloudVendor.setCloudId(cloudVendorDto.getCloudId());
			cloudVendor.setCloudName(cloudVendorDto.getCloudName());
			cloudVendor.setCloudAddress(cloudVendorDto.getCloudAddress());
			cloudVendor.setCloudPhoneNumber(cloudVendorDto.getCloudPhoneNumber());
			cloudAPIRepo.save(cloudVendor);
		    return "SUCCESS";
	}

	@Override
	public List<CloudVendorDTO> getAllVendorDetails() {
		List<CloudVendor> cloudVendorList = cloudAPIRepo.findAll();
		List<CloudVendorDTO> cloudDTOList = cloudVendorList.stream()
				.map((cloudVendor) -> CloudVendorMapper.mapToCloudVendorDTO(cloudVendor)).collect(Collectors.toList());
		return cloudDTOList;
	}

	@Override
	public String deleteVendorDetails(String vendorId) {
		CloudVendor cloudVendor = cloudAPIRepo.findById(vendorId)
				.orElseThrow(() -> new CloudVendorNotFoundException("Vendor details not Found"));
		cloudAPIRepo.deleteById(vendorId);
		return "SUCCESS";
	}

}
