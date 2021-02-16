import org.w3c.dom.ls.LSOutput;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Quiz q = new Quiz();
        Random rdx = new Random();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    q.loadNextRound();
                    System.out.print(Col.ANSI_PURPLE + Thread.currentThread().getName() + " load next round");
                    q.switchQ();
                    System.out.println(Col.ANSI_PURPLE + " and switch");
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException ie) {
                        ie.getStackTrace();
                    }
                }
            }
        };
        Runnable reader = new Runnable() {
            public void run() {
                int qTake=-1;
                String name = Thread.currentThread().getName();
                String col = "";
                switch (name) {
                    case "First": col = Col.ANSI_BLUE;break;
                    case "Second": col = Col.ANSI_CYAN;break;
                    case "Third": col = Col.ANSI_RED;break;
                    default:col=Col.ANSI_GREEN;
                }
                while(true) {
                    Random rdx = new Random();
                    int myId=rdx.nextInt(3);
                    myId=1;
                    if (myId==qTake) {
                        System.out.println(col + "" + myId + " already taken ..");
                    } else {
                        try {
                            System.out.println(col+ ""+ name + " took "+q.getQuestion(myId));
                        } catch (NoSuchQuestionExeption e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        Thread.sleep(rdx.nextInt(1000));
                       // qTake=myId;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t = new Thread(r);
        t.setName("Reader");
        Thread rd = new Thread(reader);
        rd.setName("First");
        Thread rd2 = new Thread(reader);
        rd2.setName("Second");
        Thread rd3 = new Thread(reader);
        rd3.setName("Third");
        t.start();
        rd.start();
        rd2.start();
        rd3.start();
    }


}
