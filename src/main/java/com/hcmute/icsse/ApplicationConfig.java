package com.hcmute.icsse;

import java.io.File;

public abstract class ApplicationConfig {
	private ApplicationConfig() {}
	public static final String IMG_UPLOAD_PATH = "admin"+File.separator+"img" + File.separator;
	public static final String NEWS_DIR = "1jF7ZSksjlV_iCMOE9Fv-a8VzzRyIvDfc";
	public static final String NEWS_ROOT_URL = "https://drive.google.com/drive/u/0/folders/";
	public static final String BUCKET_NAME = "myspring-198204.appspot.com";
	public static final int INDEX_EDIT_FIRST_PAGE = 1;
	public static final int INDEX_EDIT_IMG_PAGE = 2;
	public static final int INDEX_EDIT_CONTACT_PAGE = 3;
}
