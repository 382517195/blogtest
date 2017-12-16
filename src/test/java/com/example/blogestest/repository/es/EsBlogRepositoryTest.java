package com.example.blogestest.repository.es;

import com.example.blogestest.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试EsBlogRepository
 *
 * @auther AN dengchangneng
 * @create 2017/12/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData(){

        //清楚所有数据
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("1","登鹳雀楼","建发大厦","发送发送到国防生的股份归属感"));
        esBlogRepository.save(new EsBlog("2","发送给他","告诉大家","记得发数据库的交话费撒谎"));
        esBlogRepository.save(new EsBlog("3","和梵蒂冈","公司电话","发几节课萨芬多花点时间"));


    }

    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
        Pageable pageable = new PageRequest(0,20);
        String title = "大";
        String summary = "大";
        String content = "大";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        System.out.println("---------start-----------");
        if(page!=null && page.getTotalElements()>0){
            for(EsBlog esBlog:page.getContent()){
                System.out.println(esBlog.toString());
            }
        }
        System.out.println("-------------end-------------");
    }
}
