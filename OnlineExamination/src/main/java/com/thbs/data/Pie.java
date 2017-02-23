package com.thbs.data;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.SystemUtils;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Pie {

	private static final Logger log = LoggerFactory.getLogger(Pie.class);
	static File imagestorelocation ;
	
  public static void drawPieChart(String username,ArrayList<String> name,ArrayList<Integer> marks) throws IOException {

    // Create Chart
    PieChart chart = new PieChartBuilder().build();
    
    if(SystemUtils.IS_OS_LINUX){
    imagestorelocation = new File(ExamConstants.LINUX_PIE_CHART_STORE_LOCATION);
    }
    
    if(SystemUtils.IS_OS_WINDOWS){
    	imagestorelocation = new File(ExamConstants.WINDOWS_PIE_CHART_STORED_LOCATION);
    }
    
    
    if (!imagestorelocation.exists()) {
		imagestorelocation.mkdirs();
    }
    
    
    log.info("location of pieChart : "+imagestorelocation);
    // Customize Chart
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
    chart.getStyler().setAnnotationDistance(1.15);
    chart.getStyler().setPlotContentSize(.7);
    chart.getStyler().setStartAngleInDegrees(90);
    chart.getStyler().setChartBackgroundColor(Color.white);
    chart.getStyler().setPlotBorderVisible(false);

    // Series
    if(name.size()==marks.size()){
    for(int count = 0; count < name.size(); count++){
    chart.addSeries(name.get(count), marks.get(count));
    }
    }
    // Show it
   // new SwingWrapper(chart).displayChart();

    // Save it
    BitmapEncoder.saveBitmap(chart, imagestorelocation + username, BitmapFormat.JPG);

    // or save it in high-res
   // BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
  }

}