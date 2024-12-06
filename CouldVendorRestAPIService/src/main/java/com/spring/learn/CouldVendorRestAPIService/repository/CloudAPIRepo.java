package com.spring.learn.CouldVendorRestAPIService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.learn.CouldVendorRestAPIService.entity.CloudVendor;

@Repository
public interface CloudAPIRepo extends JpaRepository<CloudVendor, String> {

}
