package main.java.mx.darthill;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.Parameter;
import com.progress.open4gl.dynamicapi.ParameterSet;
import com.progress.open4gl.javaproxy.Connection;
import com.progress.open4gl.javaproxy.OpenAppObject;
import com.progress.open4gl.javaproxy.ParamArray;
import com.progress.open4gl.javaproxy.ParamArrayMode;

public class JavaAppServer {

    public void run(String broker, String programax) throws Exception {
        System.out.println("Inside run method...");

        ParamArray m_ParamArray = null;

        try {


            com.progress.open4gl.javaproxy.Connection m_Conn1 = new Connection("AppServer://192.168.40.144:5162", "admin", "dar1log2", "-URL AppServer://192.168.40.144:5162"); /*5162 is NameServerport where appservername is connected*/
            System.out.println("Before creating OpenAppObject...");
            m_Conn1.setSessionModel(0);
            System.out.println("After m_Conn1.setSessionModel...");


            //OpenAppObject m_AppObject1 = new OpenAppObject("admin", "dar1log2", "-URL AppServer://192.168.40.144:5162", "AblProcedure");  //(m_Conn1, "AblProcedure");
            OpenAppObject m_AppObject1 = new OpenAppObject(m_Conn1, broker);
            System.out.println("Connecti1on Success...");
            //AppTest test = new AppTest();
            m_ParamArray = new ParamArray(1);

            m_ParamArray.addCharacter(0, "CustomerNumber", ParamArrayMode.INPUT);
            // Crear un parámetro de tipo String
            //Parameter stringParam = new Parameter(ParameterSet.INPUT, "tuCadenaDeTexto");
            //ParameterSet parametros = new ParameterSet(1);
            //parametros.setStringParameter(0,"parametro", 1);
            //m_ParamArray.addCharacter(0, "Hola", 0);
            m_AppObject1.runProc(programax, m_ParamArray);
            System.out.println("Done");


        } catch (Open4GLException o4GLex) {
            o4GLex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String broker = "";
        String programax = "";
        if (args.length > 0) {
            // Accede al primer argumento
            broker = args[0];
            programax = args[1];

            // Utiliza el argumento en tu programa
            System.out.println("Argumento pasado: " + broker + " " + programax);
        } else {
            System.out.println("No se han pasado argumentos.");
            broker = "asbroker1";
            programax = "prueba3.r";
            System.out.println("Variables: " + broker + " " + programax);
        }
        JavaAppServer test = new JavaAppServer();
        System.out.println("Inside main method...");
        try {

            System.out.println("Calling run method...");
            test.run(broker, programax);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}