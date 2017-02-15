package com.thbs.interfaces;

import java.util.List;

import com.thbs.Beans.ImagesBean;

public interface Iimages {
	
	public List<ImagesBean> getAllImage(int id);
	public int insertImage(ImagesBean i);
	public int UpdateImageLocation(String Query,int id);

}
