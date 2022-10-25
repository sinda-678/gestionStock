package com.stockManager.sinda.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stockManager.sinda.service.FlickrService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlickrServiceImpl  implements FlickrService{

	
	

    @Value("${flickr.apiKey}")
    private String apiKey;

    @Value("${flickr.apiSecret}")
    private String apiSecret;
    

    @Value("${flickr.appiKey}")
    private String appiKey;

    @Value("${flickr.appiSecret}")
    private String appiSecret;
	@Override
	public String savePhoto(InputStream photo, String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
