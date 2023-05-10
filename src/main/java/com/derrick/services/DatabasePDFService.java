package com.derrick.services;
import com.derrick.model.Desing;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class DatabasePDFService {
    public static ByteArrayInputStream employeePDFReport(List<Desing> volunteers) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Volunteer Structure", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);
            // Add PDF Table Header ->
            Stream.of("ORDER_NO", "ORDER_DATE", "FIRST_NAME", "LAST_NAME", "YARD_SIZE","PICTURE").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.CYAN);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            for (Desing volunteer : volunteers) {
                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(volunteer.getOrderId())));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell orderdateCell = new PdfPCell(new Phrase(volunteer.getOrderDate().toString()));
                orderdateCell.setPaddingLeft(4);
                orderdateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                orderdateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(orderdateCell);

                PdfPCell firstNameCell = new PdfPCell(new Phrase(String.valueOf(volunteer.getfName())));
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                firstNameCell.setPaddingRight(4);
                table.addCell(firstNameCell);

                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(volunteer.getlName())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                lastNameCell.setPaddingRight(4);
                table.addCell(lastNameCell);

                PdfPCell yardSize = new PdfPCell(new Phrase(String.valueOf(volunteer.getYard())));
                yardSize.setVerticalAlignment(Element.ALIGN_MIDDLE);
                yardSize.setHorizontalAlignment(Element.ALIGN_CENTER);
                yardSize.setPaddingRight(4);
                table.addCell(yardSize);

                PdfPCell pictureCell = new PdfPCell(new Phrase(String.valueOf(volunteer.getPicture())));
                pictureCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pictureCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pictureCell.setPaddingRight(4);
                table.addCell(pictureCell);


            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
