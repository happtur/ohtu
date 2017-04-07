package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String courseBodyText = Request.Get("https://ohtustats2017.herokuapp.com/courses/1.json").execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( courseBodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        Course course = mapper.fromJson(courseBodyText, Course.class);
        
        int[] weekMax = {course.getWeek1(), course.getWeek2(), course.getWeek3(),
                        course.getWeek4(), course.getWeek5(), course.getWeek6()};
        
        for(int i = 0; i < subs.length; i++) {
            subs[i].setMaximi(weekMax[i]);
        }
        
        int totalTeht = 0;
        int totalTunt = 0;
        
        System.out.println("Kurssi: " + course.getName()+ ", " + course.getTerm() + "\n");
        System.out.println("opiskelijanumero: " + studentNr + "\n");
        for (Submission submission : subs) {
            System.out.println(submission);
            totalTeht += submission.getTotal();
            totalTunt += submission.getHours();
        }
        System.out.println("\nyhteensä: " + totalTeht + " tehtävää " + totalTunt + " tuntia\n");

    }
}