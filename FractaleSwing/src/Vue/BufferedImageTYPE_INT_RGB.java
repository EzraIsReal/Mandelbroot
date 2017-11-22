/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gbchamoulaud
 */
public class BufferedImageTYPE_INT_RGB extends JFrame {
  public BufferedImageTYPE_INT_RGB() {
    getContentPane().add(new DrawingCanvas());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setVisible(true);
  }

  //public static void main(String arg[]) {
  //  new BufferedImageTYPE_INT_RGB();
  //}
}

class DrawingCanvas extends JPanel {
  Font font = new Font("Dialog", Font.BOLD, 40);
  FontMetrics fontMetrics;

  DrawingCanvas() {
    setSize(300, 300);
    setBackground(Color.white);
    fontMetrics = getFontMetrics(font);
  }

  public void paint(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;
    int w = getSize().width;
    int h = getSize().height;

    BufferedImage bi = new BufferedImage(5, 5, BufferedImage.TYPE_INT_RGB);
    Graphics2D big = bi.createGraphics();
    big.setColor(Color.magenta);
    big.fillRect(0, 0, 5, 5);
    big.setColor(Color.black);
    big.fillOval(0, 0, 5, 5);
    Rectangle r = new Rectangle(0, 0, 5, 5);
    TexturePaint tp = new TexturePaint(bi, r);
    g2D.setPaint(tp);
    g2D.drawString("Graphics", 30, 100);

  }
}
