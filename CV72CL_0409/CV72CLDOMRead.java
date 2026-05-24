import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CV72CLDOMRead {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        File xmlFile = new File("XMLCV72CL.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("etterem");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("ekod");

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String name = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("varos").item(0);
                String city = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("utca").item(0);
                String street = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("hazszam").item(0);
                String number = node4.getTextContent();

                Node node5 = elem.getElementsByTagName("csillag").item(0);
                String stars = node5.getTextContent();

                String adr = city + " , " + street + " utca " + number + " , ";

                System.out.println("Étterem ID:" + id);
                System.out.println("Név:" + name);
                System.out.println("Cím:" + adr);
                System.out.println("Csillag:" + stars);
            }
        }

        nList = doc.getElementsByTagName("foszakacs");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("fkod");
                String eid = elem.getAttribute("e_f");

                String work = "Ez a főszakács az " + eid + " azonosítójú étteremben dolgozik.";

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String name = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("eletkor").item(0);
                String age = node2.getTextContent();

                Node node3;
                String edu = "";

                for (int j = 0; j < elem.getElementsByTagName("vegzettseg").getLength(); j++) {

                    node3 = elem.getElementsByTagName("vegzettseg").item(j);

                    if (j == elem.getElementsByTagName("vegzettseg").getLength() - 1) {
                        edu += node3.getTextContent();
                    } else {
                        edu += node3.getTextContent() + " ; ";
                    }
                }

                System.out.println("Étterem ID:" + id);
                System.out.println("Név:" + name);
                System.out.println("Kor:" + age);
                System.out.println("Végzettségek:" + edu);
                System.out.println(work);
            }
        }

        nList = doc.getElementsByTagName("szakacs");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("szkod");

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String name = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("Reszleg").item(0);
                String reszleg = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("Vegzettseg").item(0);
                String vegzettseg = node3.getTextContent();

                System.out.println("Szakács ID:" + id);
                System.out.println("Név:" + name);
                System.out.println("Részleg:" + reszleg);
                System.out.println("Végzettség:" + vegzettseg);
            }
        }

        nList = doc.getElementsByTagName("gyakornok");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("gykod");

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String name = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("kezdete").item(0);
                String kezdete = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("idotartam").item(0);
                String idotartam = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("muszak").item(0);
                String muszak = node4.getTextContent();

                System.out.println("Gyakornok ID:" + id);
                System.out.println("Név:" + name);
                System.out.println("Gyakorlat kezdete:" + kezdete);
                System.out.println("Időtartam:" + idotartam);
                System.out.println("Műszak:" + muszak);
            }
        }
        nList = doc.getElementsByTagName("vendeg");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String id = elem.getAttribute("vkod");

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String name = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("varos").item(0);
                String varos = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("utca").item(0);
                String utca = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("hazszam").item(0);
                String hazszam = node4.getTextContent();

                Node node5 = elem.getElementsByTagName("eletkor").item(0);
                String eletkor = node5.getTextContent();

                String cim = varos + ", " + utca + " " + hazszam;

                System.out.println("Vendég ID:" + id);
                System.out.println("Név:" + name);
                System.out.println("Cím:" + cim);
                System.out.println("Életkor:" + eletkor);
            }
        }

        nList = doc.getElementsByTagName("rendeles");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                Node node1 = elem.getElementsByTagName("etteremRef").item(0);
                String etteremRef = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("vendegRef").item(0);
                String vendegRef = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("etel").item(0);
                String etel = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("osszeg").item(0);
                String osszeg = node4.getTextContent();

                System.out.println("Étterem hivatkozás:" + etteremRef);
                System.out.println("Vendég hivatkozás:" + vendegRef);
                System.out.println("Étel:" + etel);
                System.out.println("Összeg:" + osszeg);
            }
        }
    }
}