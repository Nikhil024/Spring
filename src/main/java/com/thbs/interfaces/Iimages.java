package com.thbs.interfaces;

import java.util.List;

import com.thbs.Beans.ImagesBean;

public interface Iimages {
	
	public List<ImagesBean> getAllImage();
	public int setImage(String Query,int id);
	public int UpdateImageLocation(String Query,int id);

}
