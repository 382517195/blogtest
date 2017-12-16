package com.example.blogestest.repository.es;

import com.example.blogestest.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 接口
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {

    /**
     * 通过标题、摘要、正文查询博客内容
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
