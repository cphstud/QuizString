import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String[] questions;
    private final List<String> allQuestions;
    private final String name;
    private int numOfQ;
    private static int roundCounter=0;

    public Quiz() {
        this.questions = new String[3];
        this.allQuestions = new ArrayList<>();
        this.name = "kurt";
        initQuiz();
        numOfQ = 3;
    }

    public String getQuestion(int id) throws NoSuchQuestionExeption {
        String q = "";
        if (id > 2 || id < 0)  {
            throw new NoSuchQuestionExeption("Wrong number");
        } else {
           q=questions[id];
           questions[id]="";
        }
        return q;
    }

    public void switchQ() {
        questions = loadNextRound();
    }

    public String[] loadNextRound() {
        String[] questionsCopy = new String[numOfQ];
        // 0 0,1,2
        // 1 3,4,5
        // 2 6,7,8
        int idx=0;
        for (int i = 1; i <= numOfQ; i++) {
            questionsCopy[i-1]=allQuestions.get((2*roundCounter+1)+i);
        }
        roundCounter++;
        return questionsCopy;
    }

    private void initQuiz() {
        ClassLoader classLoader = getClass().getClassLoader();
        File f = new File(classLoader.getResource("WORLDCAPITALS").getFile());
        if (f==null) {
           System.out.println("Nul");
        }
        try {
        BufferedReader br = new BufferedReader(new FileReader(f));

        String tmpAnsw = "";
        String tmpQuestion="";
        String line = "";
        //300	WORLD CAPITALS	Home to NAT1GO & little green sprouts	Brussels

            while((line=br.readLine())!=null) {
                //System.out.println(line);
                String[] lineArr = line.split("\t");
                allQuestions.add(lineArr[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
