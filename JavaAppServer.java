import java.io.IOException;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.javaproxy.Connection;
import com.progress.open4gl.javaproxy.OpenAppObject;
import com.progress.open4gl.javaproxy.OpenProcObject;
import com.progress.open4gl.javaproxy.ParamArray;
import com.progress.open4gl.javaproxy.ParamArrayMode;
import com.progress.open4gl.*;

public class JavaAppServer {
    
        
  public void run() throws Exception
  {
    System.out.println("Inside run method...");
    
    ParamArray m_ParamArray = null;
    
    try{
                
      
com.progress.open4gl.javaproxy.Connection m_Conn1 = new Connection("AppServer://192.168.40.144:5162/AblProcedure", "", "", ""); /*5162 is NameServerport where appservername is connected*/
      
      System.out.println("Before creating OpenAppObject...");
      m_Conn1.setSessionModel(0);
      System.out.println("After m_Conn1.setSessionModel...");
      OpenAppObject m_AppObject1 = new OpenAppObject(m_Conn1, "");
      System.out.println("Connecti1on Success...");
      //AppTest test = new AppTest();
      m_ParamArray = new ParamArray(0);
      m_AppObject1.runProc("AppTest.r", m_ParamArray);
      System.out.println("Done");
        
    
    }
    catch (Open4GLException o4GLex)
    {
      o4GLex.printStackTrace();
    }
 
     catch (IOException ioex)
   {
    ioex.printStackTrace();
   }
   }
 
  public static void main(String[] args) {
    
      JavaAppServer test = new JavaAppServer();
      System.out.println("Inside main method...");
    
    try {

        System.out.println("Calling run method...");
      test.run();
    
    } catch (Exception e) {e.printStackTrace();
    }
  }
}