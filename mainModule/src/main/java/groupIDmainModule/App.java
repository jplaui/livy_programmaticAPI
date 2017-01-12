package groupIDmainModule;

import com.cloudera.livy.*;
import java.io.*;
import java.net.URI;
import groupIDpijob.PiJob;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        String livyUrl = "inser-your-livy-url";
        int samples = 10;
        String piJar = "PATH-to-....../jarJob/target/jarJob-1.jar";

        LivyClient client = null;
        LivyClientBuilder builder = null;
        try {
			builder = new LivyClientBuilder();
       		try {
       			builder.setURI(new URI(livyUrl));
       		}
			catch(java.net.URISyntaxException ex){
				ex.printStackTrace();
			}
		}
		catch(IOException e){
  			e.printStackTrace();
		}

		client = builder.build();

		try {
			System.err.printf("Uploading %s to the Spark context...\n", piJar);
			client.uploadJar(new File(piJar)).get();

			System.err.printf("Running PiJob with %d samples...\n", samples);
			double pi = client.submit(new PiJob(samples)).get();

			System.out.println("Pi is roughly: " + pi);
		}
		catch(java.lang.InterruptedException ex) {
			ex.printStackTrace();
		}
		catch(java.util.concurrent.ExecutionException ex) {
			ex.printStackTrace();
		} finally {
			client.stop(true);
		}
    }
}


// execute this file by cd into mainModule dir. then execute 
// this command: mvn exec:java -Dexec.mainClass="groupIDmainModule.App"
