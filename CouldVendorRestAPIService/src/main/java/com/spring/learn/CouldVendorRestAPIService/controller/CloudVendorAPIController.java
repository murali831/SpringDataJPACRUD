package com.spring.learn.CouldVendorRestAPIService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learn.CouldVendorRestAPIService.dto.CloudVendorDTO;
import com.spring.learn.CouldVendorRestAPIService.response.ResponseHandler;
import com.spring.learn.CouldVendorRestAPIService.service.CloudAPIService;

@RestController
@RequestMapping("/cloudvendor")
class CloudVendorAPIController {
	@Autowired
	CloudAPIService cloudAPIService;

	@GetMapping("/{vendorId}")
	public ResponseEntity<Object> getVendorDetails(@PathVariable String vendorId) {
		return ResponseHandler.responseBuilder("Requested Vendor Details given Here", HttpStatus.OK, cloudAPIService.getVendorDetails(vendorId));
//		CloudVendorDTO cloudVendorDTO = cloudAPIService.getVendorDetails(vendorId);
	}

	@GetMapping
	public List<CloudVendorDTO> getAllVendorDetails() {
		List<CloudVendorDTO> cloudVendorDTOList = cloudAPIService.getAllVendorDetails();
		return cloudVendorDTOList;

	}

	@PutMapping("/{vendorId}/update")
	public String updateVendorDetails(@PathVariable String vendorId, @RequestBody CloudVendorDTO cloudVendorDTO) {
		cloudAPIService.updateVendorDetails(vendorId, cloudVendorDTO);
		return "Vendor Updated Successfully";
	}

	@PostMapping("/addvendor")
	public String createCloudVendor(@RequestBody CloudVendorDTO cloudVendorDto) {
		cloudAPIService.createCloudVendorDetails(cloudVendorDto);
		return "Vendor Created Successfully";

	}

	@DeleteMapping("/{vendorId}")
	public String deleteVendorDetails(@PathVariable String vendorId) {
		cloudAPIService.deleteVendorDetails(vendorId);
		return "Vendor Deleted Successfully";

	}
}
