package icsse2018.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import icsse2018.model.News;

public interface NewsRepository extends CrudRepository<News,Integer>{
	List<News> findByGroupnewsidOrderByIdDesc(int groupnewsid);

}
