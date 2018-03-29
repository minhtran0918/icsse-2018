package com.hcmute.icsse;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public abstract class CloudStorageOwner {
	public static final Storage storage;
	
	static {
		storage = StorageOptions.getDefaultInstance().getService();
	}
	private CloudStorageOwner() {}
	
}
