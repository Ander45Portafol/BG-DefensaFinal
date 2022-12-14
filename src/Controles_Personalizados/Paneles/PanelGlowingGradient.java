/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.Paneles;

/**
 *  Personalized Control package
 * @author danlo
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import Controles_Personalizados.Paneles.ShadowRenderer;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

/**
 *  Personalized control class, extends events and controls depends the needs
 * @author danlo
 */
public class PanelGlowingGradient extends JComponent {

    /**
     * Gets Shadow
     * @return an integer
     */
    public int getShadowSize() {
        return shadowSize;
    }

    /**
     *  Shadow Size
     * @param shadowSize Shadow Dimensions
     */
    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    /**
     *  Border Size
     * @return an integer
     */
    public int getBorderSize() {
        return borderSize;
    }

    /**
     *  Border Size
     * @param borderSize Border Dimensions
     */
    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        refresh();
    }

    /**
     *  Color 1
     * @return Color 1
     */
    public Color getGradientColor1() {
        return gradientColor1;
    }

    /**
     * Color 1 
     * @param gradientColor1 Color 1
     */
    public void setGradientColor1(Color gradientColor1) {
        this.gradientColor1 = gradientColor1;
        refresh();
    }

    /**
     * Color 2
     * @return Color 
     */
    public Color getGradientColor2() {
        return gradientColor2;
    }

    /**
     *  Color 2
     * @param gradientColor2 Color 2
     */
    public void setGradientColor2(Color gradientColor2) {
        this.gradientColor2 = gradientColor2;
        refresh();
    }

    /**
     * Background Color
     * @return Color
     */
    public Color getBackgroundLight() {
        return backgroundLight;
    }

    /**
     * BackGround Color 
     * @param backgroundLight Background Color
     */
    public void setBackgroundLight(Color backgroundLight) {
        this.backgroundLight = backgroundLight;
        refresh();
    }

    private int shadowSize = 20;
    private int borderSize = 2;
    private Color gradientColor1 = new Color(255, 0, 0);
    private Color gradientColor2 = new Color(0, 69, 255);
    private Color backgroundLight = new Color(35, 35, 35);
    private BufferedImage imageRender;

    /**
     *  Validates properties of the control
     */
    public PanelGlowingGradient() {
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
        setBackground(new Color(20, 20, 20));
    }

    private void refresh() {
        createImageRender();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (imageRender != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.drawImage(imageRender, 0, 0, null);
            g2.dispose();
        }
        super.paintComponent(g);
    }

    private void createImageRender() {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            Insets inset = getInsets();
            imageRender = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageRender.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //  Draw shadow left
            g2.drawImage(createShadow(width, height, inset, gradientColor1, true), 0, 0, null);
            //  Draw shadow right
            g2.drawImage(createShadow(width, height, inset, gradientColor2, false), 0, 0, null);
            Area area = new Area(new Rectangle2D.Double(inset.left, inset.top, width - inset.left - inset.right, height - inset.top - inset.bottom));
            g2.setColor(getBackground());
            g2.fill(area);
            area.subtract(new Area(new Rectangle2D.Double(width / 2, 0, width / 2, height)));
            g2.setColor(backgroundLight);
            g2.fill(area);
            g2.drawImage(createBorder(width, height, inset), 0, 0, null);
            g2.dispose();
        }
    }

    private BufferedImage createShadow(int width, int height, Insets inset, Color color, boolean leftShadow) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        Path2D p = new Path2D.Double();
        double w = width - inset.left - inset.right;
        double h = height - inset.top - inset.bottom;
        if (leftShadow) {
            p.moveTo(0, 0);
            p.lineTo(w, h);
            p.lineTo(0, h);
        } else {
            p.moveTo(0, 0);
            p.lineTo(w, 0);
            p.lineTo(w, h);
        }
        g2.fill(p);
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.45f, color).createShadow(img);
    }

    private BufferedImage createBorder(int width, int height, Insets inset) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = width - inset.left - inset.right;
        int h = height - inset.top - inset.bottom;
        Color tranColor1 = toTranslucentColor(gradientColor1);
        Color tranColor2 = toTranslucentColor(gradientColor2);
        //  Draw Left
        g2.setPaint(new GradientPaint(0, h * 0.1f, tranColor1, 0, h, gradientColor1));
        g2.fill(new Rectangle2D.Double(inset.left, inset.top, borderSize, h));
        //  Draw Bottom
        g2.setPaint(new GradientPaint(0, 0, gradientColor1, w * 0.9f, 0, tranColor1));
        g2.fill(new Rectangle2D.Double(inset.left, height - inset.bottom - borderSize, w, borderSize));
        //  Draw Top
        g2.setPaint(new GradientPaint(w * 0.1f, 0, tranColor2, w, 0, gradientColor2));
        g2.fill(new Rectangle2D.Double(inset.left, inset.top, w, borderSize));
        //  Draw Right
        g2.setPaint(new GradientPaint(0, 0, gradientColor2, 0, h * 0.9f, tranColor2));
        g2.fill(new Rectangle2D.Double(width - inset.right - borderSize, inset.top, borderSize, h));
        g2.dispose();
        return img;
    }

    private Color toTranslucentColor(Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 0);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        createImageRender();
        //  Update or create new image render when componet has resize or change size
    }
}
