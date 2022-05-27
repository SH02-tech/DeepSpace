/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import View.GUI.GraphicMainView;
import View.DeepSpaceView;
import controller.Controller;
import deepspace.GameUniverse;

/**
 *
 * @author shao
 */
public class PlayWithGUI {
    public static void main(String[] args) {
        DeepSpaceView ui;
        GameUniverse game = new GameUniverse();
        ui = GraphicMainView.getInstance();
        Controller controller = Controller.getInstance();
        controller.setModelView(game,ui);
        controller.start(); 
    }
}
