package com.hcmute.icsse.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.hcmute.icsse.CloudStorageOwner;
import com.hcmute.icsse.DriveOwner;

public abstract class MyTool {

	public static boolean uploadToDrive(Drive service, MultipartFile file, String folderID, String name, boolean useOriginalName) {
		try(InputStream inp = file.getInputStream();) {
			if(service == null) {
				service = DriveOwner.getDriveService();
			}
			File fileMetadata = new File();
			if(useOriginalName) {
				fileMetadata.setName(file.getOriginalFilename());
			} else {
				fileMetadata.setName(name);
			}
			fileMetadata.setParents(Arrays.asList(new String[] {folderID}));
			fileMetadata.setMimeType(file.getContentType());
			service.files().create(fileMetadata, new InputStreamContent(file.getContentType(), inp))
			.setFields("id")
			.execute();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public static boolean isExistOnDrive(Drive service, String id) {
		try {
			if(service == null) {
				service = DriveOwner.getDriveService();	
			}
			File file = service.files().get(id).execute();
			if(file != null) {
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteDriveFolder(String folderID) {
		try {
			Drive drive = DriveOwner.getDriveService();
			drive.files().delete(folderID).execute();
			return true; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static String createDriveFolder(String parentID, String folderName) {
		try {
			Drive drive = DriveOwner.getDriveService();
			File fileMetadata = new File();
			fileMetadata.setName(folderName);
			fileMetadata.setParents(Arrays.asList(new String[] {parentID}));
			fileMetadata.setMimeType("application/vnd.google-apps.folder");
			File files = drive.files().create(fileMetadata).setFields("id").execute();
			return files.getId();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean uploadFile(MultipartFile filePart, String folderPathName, String fileName) {
		java.io.File folderPath = new java.io.File(folderPathName);
		java.io.File filePath = new java.io.File(folderPathName + fileName);
		if(!folderPath.exists()) {
			folderPath.mkdirs();
		}
		if(!filePath.exists()) {
			try {
				filePath.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		try(InputStream inp = filePart.getInputStream();
				OutputStream out = new FileOutputStream(filePath)) {
			byte[] data = new byte[2048];
			int length = 0;
			while((length = inp.read(data)) != -1) {
				out.write(data, 0, length);
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deleteFile(java.io.File file) {
		if(file.exists()) {
			if(file.isFile()) {
				return file.delete();
			} else if(file.isDirectory()) {
				java.io.File[] files = file.listFiles();
				boolean flag = true;
				for(java.io.File tmp : files) {
					flag &= deleteFile(tmp);
				}
				flag &= file.delete();
				return flag;
			}
		}
		return false;
	}

	/**
	 * Uploads a file to Google Cloud Storage to the bucket specified in the BUCKET_NAME
	 * environment variable, appending a timestamp to end of the uploaded filename.
	 */
	@SuppressWarnings("deprecation")
	public static String uploadFile(MultipartFile filePart, String fileName, boolean flag,final String bucketName) {
		// the inputstream is closed by default, so we don't need to close it here
		try {
			if(flag) {
				fileName = filePart.getOriginalFilename();
			}
			BlobInfo blobInfo = CloudStorageOwner.storage.create( BlobInfo
					.newBuilder(bucketName, fileName)
					// Modify access list to allow all users with link to read file
					.setAcl(new ArrayList<>(Arrays.asList(Acl.of(User.ofAllUsers(), Role.READER))))
					.build(),
					filePart.getBytes());
			return blobInfo.getMediaLink();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// return the public download link

	}

	public static boolean deleteFileFromGStorage(final String bucketName, String fileName) {

		return CloudStorageOwner.storage.delete(BlobId.of(bucketName, fileName));
	}

	public static String getExtension(String file) {
		int lasDotIndex = file.lastIndexOf('.');
		if(lasDotIndex > 0) {
			file = file.substring(lasDotIndex + 1);
			return file;
		}
		return null;
	}
}
