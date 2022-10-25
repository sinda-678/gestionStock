package com.stockManager.sinda.service;

import java.io.InputStream;

public interface FlickrService {

	String savePhoto(InputStream photo, String title);
}
