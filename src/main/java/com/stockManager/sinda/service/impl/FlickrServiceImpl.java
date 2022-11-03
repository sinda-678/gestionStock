package com.stockManager.sinda.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.stockManager.sinda.service.FlickrService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlickrServiceImpl  implements FlickrService{

	
	/*

    @Value("${flickr.apiKey}")
    private String apiKey;

    @Value("${flickr.apiSecret}")
    private String apiSecret;
    

    @Value("${flickr.appiKey}")
    private String appiKey;

    @Value("${flickr.appiSecret}")
    private String appiSecret;
   */
    private  Flickr flickr;
    
   
    @Autowired
    public FlickrServiceImpl(Flickr flickr) {
    	this.flickr=flickr;
    }
   
	@Override
	public String savePhoto(InputStream photo, String title) throws FlickrException {
		// TODO Auto-generated method stub
		UploadMetaData uploadMetaData = new UploadMetaData();
		uploadMetaData.setTitle(title) ;
		String photoId = flickr.getUploader().upload(photo, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}

}
