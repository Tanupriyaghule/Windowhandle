package test_case.codes;
package demo;
import java.net.MalformedURLException;
public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        Windowhandle tests = new Windowhandle(); // Initialize your test class
        //TODO: call your test case functions one after other here
       tests.testcase03();
        //END Tests
         tests.endTest(); // End your test by clearning connections and closing browser
     
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}