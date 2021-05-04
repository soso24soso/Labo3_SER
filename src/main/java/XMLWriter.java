import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

public class XMLWriter {

    public XMLWriter(){

    }

    public void fct(String xmlFilePath) {

        try {

            Element root = new Element("kml");
            root.setAttribute("xmlns", "http://www.opengis.net/kml/2.2");
            Document document = new Document(root);

            Element placemark = new Element("Placemark");

            Element name = new Element("name");
            name.setText("$feature.properties.ADMIN");
            placemark.addContent(name);

            root.addContent(placemark);

            Element polygon = new Element("Polygon");
            Element extrude = new Element("extrude");
            extrude.setText("1");
            polygon.addContent(extrude);

            // TODO

            XMLOutputter xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(document, new FileWriter(xmlFilePath));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
