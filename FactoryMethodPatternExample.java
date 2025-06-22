public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Create and open Word document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Create and open PDF document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Create and open Excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}

// ===== Step 2: Document Interface =====
interface Document {
    void open();
}

// ===== Step 3: Concrete Document Classes =====
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word document.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel document.");
    }
}

// ===== Step 4: Abstract Factory =====
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// ===== Step 4: Concrete Factories =====
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
    
}
