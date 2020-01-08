package com.gwxtd.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.Comment;
import com.gwxtd.core.appbean.RCommentCount;
import com.gwxtd.core.appbean.RGoodComment;
import com.gwxtd.core.appbean.RProductComment;
import com.gwxtd.core.dao.AppCommentMapper;
import com.gwxtd.core.dao.OrderMapper;
import com.gwxtd.core.service.AppCommentService;
@Service
@Transactional
public class AppCommentServiceImpl implements AppCommentService{
	@Autowired
	private AppCommentMapper appCommentMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Override
	public List<RGoodComment> selectByPid(int pid,int type) {
		List<Comment> list = appCommentMapper.getListByPid(pid,type,0);
		List<RGoodComment> comments = new ArrayList<>();
		for(Comment com:list){
			RGoodComment comment = new RGoodComment();
			String images = com.getImgUrls();
			if(images!=null){
				comment.setImgUrls(images.split(","));
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(com.getTime());
			comment.setTime(time);
			comment.setUserName(com.getuName());
			comment.setRate(com.getRate());
			comment.setType(com.getType());
			comment.setComment(com.getComment());
			comments.add(comment);
		}
		return comments;
	}
	@Override
	public RCommentCount selectCommentCount(long id) {
		RCommentCount count = new RCommentCount();
		//全部评论数
		int allCount = appCommentMapper.countByPid((int)id,0,0);
		count.setAllComment(allCount);
		//好评数
		int goodCount = appCommentMapper.countByPid((int)id,1,0);
		count.setPositiveCom(goodCount);
		//中评数
		int middleCount = appCommentMapper.countByPid((int)id,2,0);
		count.setModerateCom(middleCount);
		//差评数
		int wantingCount = appCommentMapper.countByPid((int)id,3,0);
		count.setNegativeCom(wantingCount);
		//有图评论数
		int hasImage = appCommentMapper.countByPid((int)id,0,1);
		count.setHasImgCom(hasImage);
		return count;
	}
	@Override
	public List<RProductComment> selectComment(int pid, int type, boolean isImg) {
		List<Comment> list = appCommentMapper.getListByPid(pid,type,isImg?1:0);
		List<RProductComment> productComments = new ArrayList<>();
		for(Comment comment:list){
			RProductComment productComment = new RProductComment();
			productComment.setId(comment.getId());
			productComment.setRate(comment.getRate());
			productComment.setComment(comment.getComment());
			if(comment.getImgUrls()!=null){
				productComment.setImgUrls(comment.getImgUrls().split(","));
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = orderMapper.getDateByOgid(comment.getOgid());
			productComment.setBuyTime(sdf.format(date));
			if(comment.getProductType()!=null){
				productComment.setProductType(comment.getProductType());
			}
			productComment.setUserLevel(comment.getuLevel());
			productComment.setUserName(comment.getuName());
			productComment.setUserImg(comment.getuIcon());
			productComment.setCommentTime(sdf.format(comment.getTime()));
			productComment.setLoveCount(comment.getLoveCount());
			productComment.setSubComment(comment.getSubComment());
			productComments.add(productComment);
		}
		return productComments;
	}
}
