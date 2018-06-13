package com.github.jumpt57;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

final class Browser extends Region {

    private static final String PAGE_PATH = "/index.html";
    private final WebView browser = new WebView();

    Browser() {
        String url = WebViewSample.class.getResource(PAGE_PATH).toExternalForm();
        WebEngine webEngine = browser.getEngine();
        webEngine.load(url);

        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == Worker.State.SUCCEEDED){
                var win = (JSObject) webEngine.executeScript("window");
                win.setMember("app", new JavaApp());
            }
        });

        getChildren().add(browser);
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    protected double computePrefWidth(double height) {
        return 750;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 500;
    }


    public static class JavaApp {

        public void exit() {
            Platform.exit();
        }

        public void log(String msg) {
            System.out.println(msg);
        }

    }
}
