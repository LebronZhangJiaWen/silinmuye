/*
package com.muyenet.muye.web.pachong;

*/
/**
 * Created by zhangjiawen on 2018/1/23.
 * 读取当当网下首页图书的数据，并进行分析
 * 爬取深度为2
 * 爬去数据存储到E:/dangdang_book/目录下，需自行创建
 * sunwengang   2017-08-13  20：00
 *//*


import com.muyenet.muye.dao.cms.IArticleDao;
import com.muyenet.muye.model.cms.Article;
import com.muyenet.muye.model.common.Archive;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.service.cms.IArticleService;
import com.muyenet.muye.service.common.IArchiveService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class URLDemoDuanziTask {
    private Logger logger=Logger.getLogger(URLDemoDuanziTask.class);
    @Resource
    private IArticleDao articleDao;
    @Resource
    private  IArchiveService archiveService;
    private  static List<Archive> archiveList=new ArrayList<>();
    private  String  strurl="http://neihanshequ.com/pic/";
    @Scheduled(cron = "0 0/2 * * * ?")
    private void workurl(){

            //建立url爬取核心对象
            try {
                URL url=new URL(this.strurl);
                //通过url建立与网页的连接
                URLConnection conn=url.openConnection();
                //通过链接取得网页返回的数据
                InputStream is=conn.getInputStream();

                //System.out.println(conn.getContentEncoding());
                //一般按行读取网页数据，并进行内容分析
                //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
                //进行转换时，需要处理编码格式问题
                BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                //按行读取并打印
                String line=null;
                String result = "";
                while((line=br.readLine())!=null){
                    result += line;
                }
                 Pattern titleP=Pattern.compile("<p>.+</p>");
                 Pattern imgP=Pattern.compile("data-src=.+");
                //根据<div class="content-wrapper"> 截取HTML 并掐头
                String[] strings = result.split("<div class=\"content-wrapper\">");
                for (int i = 1; i <strings.length ; i++) {
                    String str=strings[i];
                    //根据  内部截取 去尾
                    String[] split = str.split("<div class=\"options\" data-group-id");
                    String finalStr=split[0];
                    Matcher mTitle=titleP.matcher(finalStr);
                    Matcher mImg=imgP.matcher(finalStr);
                    Archive archive=new Archive();
                    archive.setBadNum(0);
                    archive.setCanReply(0);
                    archive.setKeywords(null);
                    archive.setViewRank(0);
                    archive.setViewCount(3);
                    archive.setWriter("内涵段子");
                    archive.setSource(null);
                    //正则取标题 取图片
                    while(mTitle.find()){
                        String content=mTitle.group();
                        content=content.substring(3,content.indexOf("</p>")).trim();
                        archive.setTitle(content);
                        archive.setDescription(content);
                        logger.info(content);
                    }
                    int k=0;
                    while(mImg.find()){
                        String content=mImg.group();
                        content= content.substring(10,content.indexOf("data-image-info"));
                        content=content.substring(0,content.indexOf("\""));
                        logger.info(content);
                       if (k==0){
                           archive.setThumbnail(content);
                           content="<p><img src=\""+content+"\" /></p>";
                           archive.setContent(content);
                       }
                    }
                    archiveList.add(archive);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        if(archiveList.size()>0){
            for (int i = 0; i <archiveList.size() ; i++) {
                Archive ac= archiveList.get(i);
                if (ac.getTitle()==null){
                    continue;
                }
                Member member=new Member();
                member.setId(1);
                try {
                    if (archiveService.findByArchiveTitle(ac.getTitle()) == 0) {
                        archiveService.save(member, ac);
                        Integer archiveId=ac.getArchiveId();
                        Article article=new Article();
                        article.setArchiveId(archiveId);
                        article.setCateId(6);
                        article.setStatus(1);
                        articleDao.save(article);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }
            }

        }
        archiveList.clear();

        }


}*/
