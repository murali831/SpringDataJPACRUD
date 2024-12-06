package com.spring.learn.CouldVendorRestAPIService.dto;

public class CloudVendorDTO {
	private String cloudId;
	private String cloudName;
	private String cloudAddress;
	private String cloudPhoneNumber;
	
	public String getCloudId() {
		return cloudId;
	}
	public void setCloudId(String cloudId) {
		this.cloudId = cloudId;
	}
	public String getCloudName() {
		return cloudName;
	}
	public void setCloudName(String cloudName) {
		this.cloudName = cloudName;
	}
	public String getCloudAddress() {
		return cloudAddress;
	}
	public void setCloudAddress(String cloudAddress) {
		this.cloudAddress = cloudAddress;
	}
	public String getCloudPhoneNumber() {
		return cloudPhoneNumber;
	}
	public void setCloudPhoneNumber(String cloudPhoneNumber) {
		this.cloudPhoneNumber = cloudPhoneNumber;
	}
	@Override
	public String toString() {
		return "CloudVendor [cloudId=" + cloudId + ", cloudName=" + cloudName + ", cloudAddress=" + cloudAddress
				+ ", cloudPhoneNumber=" + cloudPhoneNumber + "]";
	}
	public CloudVendorDTO(String cloudId, String cloudName, String cloudAddress, String cloudPhoneNumber) {
		super();
		this.cloudId = cloudId;
		this.cloudName = cloudName;
		this.cloudAddress = cloudAddress;
		this.cloudPhoneNumber = cloudPhoneNumber;
	}
	public CloudVendorDTO() {
		super();
	}
	
}
