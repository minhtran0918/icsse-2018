package com.hcmute.icsse.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcmute.icsse.ApplicationConfig;
import com.hcmute.icsse.entity.Admin;
import com.hcmute.icsse.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository admRepository;

	public List<Admin> findAllAdmins() {
		try {
			return (List<Admin>) admRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Admin addContact(Admin adm) {
		try {
			return admRepository.save(adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteContact(int uid) {
		try {
			 Admin adm = admRepository.findById(uid).get();
			 if(adm != null) {
				MyTool.deleteFileFromGStorage(ApplicationConfig.BUCKET_NAME, adm.getAdmImgName());
			 }
			 admRepository.deleteById(uid);
			 return true;
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		return false;
	}
	
	public Admin updateContact(Admin adm) {
		try {
			return admRepository.save(adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Admin findContactById(int uid) {
		try {
			return admRepository.findById(uid).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Admin changePass(Admin adm) {
		try {
			return admRepository.save(adm);
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}
	
	/*public Admin uploadImage(Admin adm, MultipartFile file) {
		String oldFilePath = (adm.getAdmImg() == null)?"":adm.getAdmImg();
		String folder = adm.getAdmAccount();
		String fileName = file.getOriginalFilename();
		String path = ApplicationConfig.IMG_UPLOAD_PATH + folder + File.separator;
		String newFilePath = path + fileName;
		if(MyTool.uploadFile(file, path, fileName)) {
			adm.setAdmImg(newFilePath);
			if(admRepository.save(adm) != null) {
				MyTool.deleteFile(new File(oldFilePath));
				return adm;
			} else {
				MyTool.deleteFile(new File(newFilePath));
				return null;
			}
		} else {
			return null;
		}
	}*/
	
	public Admin uploadImageToGStorage(Admin adm, MultipartFile file) {
		String oldFileName = adm.getAdmImgName();
		String prefix = adm.getAdmAccount();
		String fileName = file.getOriginalFilename();
		String newFileName = String.format("%s-%s", prefix, fileName);
		String link = null;
		if((link = MyTool.uploadFile(file, newFileName, false, ApplicationConfig.BUCKET_NAME)) != null) {
			adm.setAdmImg(link);
			adm.setAdmImgName(newFileName);
			if(admRepository.save(adm) != null) {
				MyTool.deleteFileFromGStorage(ApplicationConfig.BUCKET_NAME, oldFileName);
				return adm;
			} else {
				MyTool.deleteFileFromGStorage(ApplicationConfig.BUCKET_NAME, newFileName);
				return null;
			}
		} else {
			return null;
		}
	}
}
