package org.example.crud.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.example.crud.model.Students;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;
public class DatabasePDFService {

    public static ByteArrayInputStream studentPDFReport(List<Students> students) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();


            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Student Details", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            addTableHeader(table);
            addRows(table, students);

            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static void addTableHeader(PdfPTable table) {
        Stream.of("ID", "Name", "Address", "Age").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);

            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle, headFont));
            table.addCell(header);
        });
    }

    private static void addRows(PdfPTable table, List<Students> students) {
        for (Students student : students) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getName());
            table.addCell(student.getAddress());
            table.addCell(String.valueOf(student.getAge()));
        }
    }
}
