package cn.youye.back.controller;

import cn.youye.back.sys.common.BaseController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;


/**
 * Created by pc on 2016/8/29.
 */

public class CountTest extends BaseController {


    public static DefaultCategoryDataset createDataSet() {

        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        dataset.addValue(100,"测试1","结果1");
        dataset.addValue(230,"测试2","结果2");
        dataset.addValue(200,"测试3","结果3");
        dataset.addValue(310,"测试4","结果4");
        return dataset;
    }
    public static JFreeChart createChart(){
        JFreeChart chart=ChartFactory.createBarChart(
                "统计数量","类型","结果",createDataSet(),
                PlotOrientation.VERTICAL,
                true,true,false
        );
        return chart;
    }
}
