package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author: jiangyong
 * @date: 2019/2/28 22:49
 * @version:
 * @Copyright:
 * @modifier:
 */
@Service
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;

    /**
     * 增加文章
     *
     * @param article
     */
    public void save(Article article) {
        articleSearchDao.save(article);
    }

    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
    }
}
