import java.io.{File, PrintWriter}

import org.json4s.Xml.toJson

import scala.xml.XML

object task extends App {

 //Getting XML file
 val LVmeta =XML.loadFile("./src/resources/LV_meta.xml")

 //val stations= for (i<-LVmeta) yield i \\"station_info"
 //stations.foreach(el=>println(el.text))


 //Receiving station_info from XML
 val stations=LVmeta\\"station"\"station_info"

 //To Json
 val xml_json=toJson(stations)
 println(xml_json)


 //Writing info to new file, using java.io
 //Without toString it wouldn't write to file, but outcome isn't looking good
 val pw = new PrintWriter(new File("stations.json" ))
pw.write((xml_json).toString)
pw.close


}