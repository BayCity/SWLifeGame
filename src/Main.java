import Control.controller;
import VIew.GameFrame;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        controller controller=new controller();
        Thread thread=new Thread(controller);
        thread.start();
    }
}
