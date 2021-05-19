package com.vaadin.tutorial.crm.backend.library.generator;//package com.vaadin.tutorial.crm.backend.library.generator;
//
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import org.springframework.stereotype.Component;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class QrCodeGenerator {
//
//    private static final Float DEFAULT_OVERLAY_TRANSPARENCY = 1f;
//    private static final Float DEFAULT_OVERLAY_TO_QR_CODE_RATIO = 0.25f;
//
//    private final String DIR = "/qrcodes";
//    private final String ext = ".png";
//    private final String LOGO = "http://194.180.12.60:8444/attachments/qr_img.jpg";
//    private final int WIDTH = 300;
//    private final int HEIGHT = 300;
//
//    public BufferedImage generate(String content) throws IOException, WriterException {
//        // Create new configuration that specifies the error correction
//        Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
//        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//
//        QRCodeWriter writer = new QRCodeWriter();
//        // Create a qr code with the url as content and a size of WxH px
//        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
//
//        // Load QR image
//        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
//
//        return decorate(qrImage);
//    }
//
//    private BufferedImage getOverly(String LOGO) throws IOException {
//        URL url = new URL(LOGO);
//        return ImageIO.read(url);
//    }
//
//    private BufferedImage decorate(BufferedImage qrcode) throws IOException {
//        BufferedImage scaledOverlay = scaleOverlay(qrcode);
//
//        int deltaHeight = qrcode.getHeight() - scaledOverlay.getHeight();
//        int deltaWidth = qrcode.getWidth() - scaledOverlay.getWidth();
//
//        BufferedImage combined = new BufferedImage(qrcode.getWidth(), qrcode.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2 = (Graphics2D) combined.getGraphics();
//        g2.drawImage(qrcode, 0, 0, null);
//        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, DEFAULT_OVERLAY_TRANSPARENCY));
//        g2.drawImage(scaledOverlay, Math.round(deltaWidth / 2), Math.round(deltaHeight / 2), null);
//
//        return combined;
//    }
//
//
//    private BufferedImage scaleOverlay(BufferedImage qrcode) throws IOException {
//        BufferedImage overlay = getOverly(LOGO);
//        int scaledWidth = Math.round(qrcode.getWidth() * DEFAULT_OVERLAY_TO_QR_CODE_RATIO);
//        int scaledHeight = Math.round(qrcode.getHeight() * DEFAULT_OVERLAY_TO_QR_CODE_RATIO);
//
//        BufferedImage imageBuff = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
//        Graphics g = imageBuff.createGraphics();
//        g.drawImage(
//                overlay.getScaledInstance(scaledWidth, scaledHeight, BufferedImage.SCALE_SMOOTH),
//                0,
//                0,
//                new Color(255, 255, 255),
//                null);
//        g.dispose();
//
//        return imageBuff;
//    }
//
//}
