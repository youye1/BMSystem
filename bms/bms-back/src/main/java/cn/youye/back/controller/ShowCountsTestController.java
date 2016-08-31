package cn.youye.back.controller;

import cn.youye.back.sys.common.BaseController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Date;


/**
 * Created by pc on 2016/8/29.
 */
@Controller
public class ShowCountsTestController extends BaseController {


    @RequestMapping("/showCounts")
    public String showCounts(HttpServletRequest request, HttpServletResponse response,Model model) {

        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        //数据集
        dataset.addValue(100, "", "体重1");
        dataset.addValue(200, "", "体重2");
        dataset.addValue(300, "", "体重3");
        dataset.addValue(400, "", "体重4");
        dataset.addValue(150, "", "体重5");
        dataset.addValue(250, "", "体重6");
        dataset.addValue(300, "", "体重7");
        JFreeChart chart=createChart("统计图","体重","kg",dataset);
        try {
            String fileName="统计图表.jpg";
            String fileURL=request.getSession().getServletContext().getRealPath("/" + "temp/");
            File fileTemp=new File(fileURL);
            if (!fileTemp.exists()){
                fileTemp.mkdirs();
            }
            File file=new File(fileURL+fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            // 生成图片并输出
//            ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart,500, 300);

            //保存图片
            ChartUtilities.saveChartAsJPEG(file,chart,500,300,null);
            model.addAttribute("msg","hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("msg","hello");
        return "modules/show/CountsTest";
    }
    public JFreeChart createChart(String title, String xAxis, String yAxis, CategoryDataset dataset) {

        //柱状图
        //1.title 2.x轴标题 3.y轴标题 4.数据集 5.样式 6.是否显示图例 7.是否生成工具 8.是否有URLs
        JFreeChart chart = ChartFactory.createBarChart(
                title, xAxis, yAxis, dataset, PlotOrientation.VERTICAL, false, true, false);

        try {
            // 设置整个图片的背景色
            chart.setBackgroundPaint(Color.white);
            // 设置图片无边框
            chart.setBorderVisible(false);
            chart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));// 图片标题字体
//            chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));//图例类别字体
            //设置图例字体清晰
//            chart.setAntiAlias(true);

            // 得到坐标设置字体解决乱码
            CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();//画布，用于设置显示特性
            categoryplot.setNoDataMessage("没有数据！");
            categoryplot.setRangeCrosshairPaint(Color.WHITE);//数据轴网格线颜色
            categoryplot.setRangeGridlineStroke(new BasicStroke(0.2f));//设置数据轴网格线笔触
            categoryplot.setDomainGridlinesVisible(false);//分类轴网格线不可见
            categoryplot.setRangeCrosshairVisible(true);//数据轴网格线可见
            categoryplot.setForegroundAlpha(0.5f);
            //数据轴设置(y轴)
            NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();//数据轴精度
            numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); // 设置刻度单位 为Integer

            numberaxis.setTickLabelFont(new Font("黑体", Font.BOLD, 12));//类别字体
            numberaxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 14));//标题字体
            numberaxis.setUpperMargin(0.1);//最高的柱子距离顶部的距离
//            numberaxis.setLowerMargin(0.1);//最矮的柱子和底部见的距离

            //类别轴设置(x轴)
            CategoryAxis domainAxis = categoryplot.getDomainAxis();
            //设置X轴坐标上的文字
            domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
            //设置X轴的标题文字
            domainAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 14));
            //设置类别轴的位置及倾斜度
            domainAxis.setCategoryLabelPositions(
                    CategoryLabelPositions.createUpRotationLabelPositions(
                            0.5235987755982988D));

            //渲染 设置柱子样式
            BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();
            barrenderer.setMaximumBarWidth(0.05);//设置柱子宽度
            barrenderer.setSeriesPaint(0, new Color(28, 131, 206));//设置柱子颜色
            barrenderer.setItemMargin(0.2D); //设置柱子的间距
            barrenderer.setBaseOutlinePaint(Color.BLACK);//柱子边框颜色
            barrenderer.setDrawBarOutline(true);   //柱子边框可见
            barrenderer.setBaseItemLabelFont(new Font("微软雅黑", Font.BOLD, 14));
            barrenderer.setSeriesItemLabelFont(1, new Font("微软雅黑", Font.BOLD, 14));

            // 显示每个柱的数值，并修改该数值的字体属性
            barrenderer.setIncludeBaseInRange(true);
            barrenderer.setBaseItemLabelGenerator(
                    new StandardCategoryItemLabelGenerator());
            barrenderer.setBaseItemLabelsVisible(true);

            //这句代码解决了底部汉字乱码的问题
//            chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 12));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chart;
    }

    @RequestMapping(value = "showImg")
    public void showImg(HttpServletRequest request, HttpServletResponse response) {
        File file = new File(request.getSession().getServletContext().getRealPath("/" + "temp/") + File.separator + "统计图表.jpg");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferInputStream = new BufferedInputStream(inputStream);
            response.setContentType("img/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputStream = response.getOutputStream();
            int byteRead = 0;
            byte[] tmpByte = new byte[1024];
            while ((byteRead = bufferInputStream.read(tmpByte)) != -1) {
                outputStream.write(tmpByte);
                outputStream.flush();
            }
            outputStream.close();
            inputStream.close();
            bufferInputStream.close();
            file.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
