package com.vaadin.tutorial.crm.backend.library.generator;//package com.vaadin.tutorial.crm.backend.library.generator;
//
//import com.itextpdf.text.pdf.BaseFont;
//import com.vaadin.tutorial.crm.backend.library.property.MakeryProperties;
//import lombok.extern.log4j.Log4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//import org.w3c.tidy.Tidy;
//import org.xhtmlrenderer.pdf.ITextRenderer;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.FileSystems;
//import java.util.Iterator;
//import java.util.Map;
//
//@Component
//@Log4j
//public class PdfGenerator {
//
//    private final MakeryProperties makeryProperties;
//    private final TemplateEngine templateEngine;
//
//    @Autowired
//    public PdfGenerator(MakeryProperties makeryProperties, TemplateEngine templateEngine) {
//        this.makeryProperties = makeryProperties;
//        this.templateEngine = templateEngine;
//    }
//
//    public String createPdf(String templateName, Map map, String productNumber) throws Exception {
//        Assert.notNull(templateName, "The templateName can not be null");
//        Context context = new Context();
//        context.setLocale(LocaleContextHolder.getLocale());
//        if (map != null) {
//            Iterator mapIterator = map.entrySet().iterator();
//            while (mapIterator.hasNext()) {
//                Map.Entry pair = (Map.Entry) mapIterator.next();
//                context.setVariable(pair.getKey().toString(), pair.getValue());
//            }
//        }
//
//        String processedHtml = templateEngine.process(templateName, context);
//        String xHtml = xhtmlConvert(processedHtml);
//        FileOutputStream os = null;
//        String fileName = productNumber + ".pdf";
//
//        try {
//            final File outputFile = new File(fileName);
//            outputFile.createNewFile();
//            os = new FileOutputStream(outputFile);
//
//            ITextRenderer renderer = new ITextRenderer();
//            String baseUrl = FileSystems
//                    .getDefault()
//                    .getPath(makeryProperties.getFontsPath())
//                    .toUri()
//                    .toURL()
//                    .toString();
//
//            renderer.getFontResolver().addFont(
//                    makeryProperties.getFontsPath() + "Poppins-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED
//            );
//            renderer.setDocumentFromString(xHtml, baseUrl);
//            renderer.layout();
//            renderer.createPDF(os);
//
//            os.close();
//
//            log.info("PDF created successfully");
//
//            return fileName;
//        } finally {
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) { /*ignore*/ }
//            }
//        }
//    }
//
//    private String xhtmlConvert(String html) throws UnsupportedEncodingException {
//        Tidy tidy = new Tidy();
//        tidy.setInputEncoding("UTF-8");
//        tidy.setOutputEncoding("UTF-8");
//        tidy.setXHTML(true);
//
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8.name()));
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        tidy.parseDOM(inputStream, outputStream);
//
//        return outputStream.toString(StandardCharsets.UTF_8.name());
//    }
//
//}
