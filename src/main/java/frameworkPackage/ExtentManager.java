package frameworkPackage; 

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static String reportFileName = "Test-Automaton-Report"+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
    private static String xmlConfigFileName = "extent-config"+".xml";
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
       
        ExtentSparkReporter extSprkReporter = new ExtentSparkReporter(fileName);
        extSprkReporter.loadXMLConfig(xmlConfigFileName);
        //extSprkReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        //extSprkReporter.config().setChartVisibilityOnOpen(true);
        /*extSprkReporter.config().setTheme(Theme.DARK);
        extSprkReporter.config().setDocumentTitle(reportFileName);
        extSprkReporter.config().setEncoding("utf-8");
        extSprkReporter.config().setReportName(reportFileName);
        extSprkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");*/
 
        extent = new ExtentReports();
        extent.attachReporter(extSprkReporter);
        //Set environment details
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("OS Version", System.getProperty("os.version"));
		//extent.setSystemInfo("OS Architecture", System.getProperty("os.arch"));
 
        return extent;
    }
     
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
 
}