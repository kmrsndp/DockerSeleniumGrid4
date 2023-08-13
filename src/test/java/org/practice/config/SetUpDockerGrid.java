package org.practice.config;

import org.testng.annotations.*;

import java.io.IOException;

public class SetUpDockerGrid {

    @BeforeSuite
    void startDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start start_docker.bat");
        Thread.sleep(15000);
    }

    @AfterSuite
    void stopDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start stop_docker.bat");
        Thread.sleep(10000);

        Runtime.getRuntime().exec("taskKill /f /im cmd.exe"); //closes cmd
    }
}
