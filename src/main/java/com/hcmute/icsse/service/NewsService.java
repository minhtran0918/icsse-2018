package com.hcmute.icsse.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.drive.Drive;
import com.hcmute.icsse.ApplicationConfig;
import com.hcmute.icsse.DriveOwner;
import com.hcmute.icsse.entity.News;
import com.hcmute.icsse.repository.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository newsRepository;

	public News addNews(News news) {
		try {
			return newsRepository.save(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public News updateNews(News news) {
		try {
			return newsRepository.save(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<News> findLatestNews() {
		try {
			return newsRepository.findLatestNews();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<News> findAllNews() {
		try {
			return (List<News>)newsRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public News findNews(int nid) {
		try {
			return newsRepository.findById(nid).get();
		} catch(NoSuchElementException exp) {
			exp.printStackTrace();
		}
		return null;
	}

	public boolean deleteNews(int nid) {
		try {
			News news = newsRepository.findById(nid).get();
			String folderID = news.getNewsFolderId();
			newsRepository.deleteById(nid);
			return MyTool.deleteDriveFolder(folderID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public News editNews(News news) {
		try {
			return newsRepository.save(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean uploadImage(News news, MultipartFile file) {
		try {
			Drive service = DriveOwner.getDriveService();
			String folderID = news.getNewsFolderId();
			if(folderID == null || folderID.equals("") || !MyTool.isExistOnDrive(service, folderID)) {
				String realFolderID = MyTool.createDriveFolder(
						ApplicationConfig.NEWS_DIR, 
						String.format("news.%d", news.getNewsId()));
				if(realFolderID == null || realFolderID.equals("")) {
					return false;
				}
				news.setNewsFolderId(realFolderID);
				if(newsRepository.save(news) == null) {
					MyTool.deleteDriveFolder(realFolderID);
					return false;
				}
			}
			if(!MyTool.uploadToDrive(service, file, news.getNewsFolderId(), null, true)) {
				return false;
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
