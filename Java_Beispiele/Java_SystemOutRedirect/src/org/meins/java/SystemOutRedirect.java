/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class SystemOutRedirect extends Application {

  @Override
  public void start(Stage primaryStage) {

    final TextArea textArea = new TextArea();

    /**
     * The original PrintStreams should stay referenced, so the will not get
     * GCed.
     */
    PrintStream oldOut = System.out;
    PrintStream oldErr = System.err;
    
    // New PrintStream: 
    final PrintStream textAreaPrintStream = new PrintStream(new OutputStream() {

      @Override
      public void write(int b) throws IOException {
        char c = (char) b;
        textArea.appendText(Character.toString(c));
      }
    });

    System.setOut(textAreaPrintStream);
    System.setErr(textAreaPrintStream);

    final Button btLog = new Button("Write to Log ...");
    btLog.setOnAction((ActionEvent event) -> {
      System.out.println("Write to log ...");
    });

    final Button btExceptions = new Button("Exception ...");
    btExceptions.setOnAction((ActionEvent event) -> {
      try {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      } catch (UnsupportedOperationException ex) {
        ex.printStackTrace();
      }
    });
    ToolBar toolBar = new ToolBar(btLog, btExceptions);
    VBox.setVgrow(textArea, Priority.ALWAYS);

    VBox root = new VBox(toolBar, textArea);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Java - System.out/System.err-Redirection");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
