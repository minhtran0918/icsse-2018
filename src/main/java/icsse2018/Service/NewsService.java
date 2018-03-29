package icsse2018.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import icsse2018.dao.NewsRepository;
import icsse2018.model.News;

@Service
@Transactional
public class NewsService {
	private final NewsRepository newsRepository;
	public NewsService(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}
	public List<News> findAll(int groupnewsid){
		List<News> newss = new ArrayList<>();
		for(News news : newsRepository.findByGroupnewsidOrderByIdDesc(groupnewsid)){
			newss.add(news);
		}
		return newss;
	}
	public  News findNews(int id){
		return newsRepository.findById(id).orElse(null);
	}
	
	public void save(News news){
		newsRepository.save(news);
	}
	
	public void delete(int id){
		newsRepository.deleteById(id);
	}
}
