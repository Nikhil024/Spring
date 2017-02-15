package com.growagro.Interfaces;

import java.util.List;

import com.growagro.Bean.ImagesBean;

public interface IimagesData {

	public int insertImagesData(ImagesBean img);
	
	public int deleteImagesData(ImagesBean img);
	
	public List<ImagesBean> allImages();
	
}
