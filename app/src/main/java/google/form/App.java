/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package google.form;

public class App {
    public void  getGreeting() throws InterruptedException {
         // This is to remove unnecessary warnings from your console
         System.setProperty("java.util.logging.config.file", "logging.properties");
        
         TestCases tests = new TestCases(); // Initialize your test class
 
         //TODO: call your test case functions one after other here
 
         tests.testCase01();
         tests.testcase02();
         tests.testcase03();
         tests.testcase04();
         tests.testcase05();
         Thread.sleep(3000);
         tests.testcase06();
         Thread.sleep(3000);
         tests.testcase07();
         tests.testcase08();
         tests.testcase09();
         tests.testcase10();
         tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException {
        new App().getGreeting();
    }
}
