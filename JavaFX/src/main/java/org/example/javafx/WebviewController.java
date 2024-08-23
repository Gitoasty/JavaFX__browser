package org.example.javafx;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class WebviewController implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private TextField field; //make sure you have the right import

    private WebEngine engine;
    private WebHistory history;

    private String homepage;

    private double webZoom;

    public void loadPage() {
        //engine.load("http://www.google.com");
        engine.load("http://" + field.getText());
    }

    public void refreshPage() {
        engine.reload();
    }

    public void zoomIn() {
        webZoom += 0.25;
        webView.setZoom(webZoom);
    }

    public void zoomOut() {
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }

    public void displayHistory() {

        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for (WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        }
    }

    public void back() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        field.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void forward() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        field.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void executeJS() {

        engine.executeScript("window.location = \"https://www.youtube.com\";");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        engine = webView.getEngine();
        homepage = "www.google.com";
        webZoom = 1;
        field.setText(homepage);
        loadPage();
    }
}
