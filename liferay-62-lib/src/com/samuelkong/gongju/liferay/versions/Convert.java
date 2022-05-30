package com.samuelkong.gongju.liferay.versions;

import com.samuelkong.gongju.liferay.versions.util.PropsValues;
import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.liferay.versions.model.Library;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Convert {

	public static void main(String[] args) throws Exception {
		List<Library> libraries = getJars(PropsValues.INPUT_FILE);

		String pomXml = toPomXml(libraries);

		FileUtil.write(pomXml, PropsValues.OUTPUT_FILE);
	}

	protected static List<Library> getJars(File file) throws Exception {
		List<Library> libraries = new ArrayList<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(file);

		NodeList libraryNodeList = document.getElementsByTagName("library");

		for (int i = 0; i < libraryNodeList.getLength(); i++) {
			Element libraryElement = (Element)libraryNodeList.item(i);

			String fileName = libraryElement
					.getElementsByTagName("file-name")
					.item(0)
					.getTextContent();
			String version = libraryElement
					.getElementsByTagName("version")
					.item(0)
					.getTextContent();

			if (!fileName.startsWith(_LIB_PORTAL_PATH)) {
				continue;
			}

			String jarName = fileName.replaceFirst(_LIB_PORTAL_PATH, "");


			Library library = new Library(jarName, version);

			if (library.getArtifact() == null) {
				System.out.println("Unknown JAR: " + jarName);

				continue;
			}

			libraries.add(library);
		}

		return libraries;
	}

	protected static List<Library> getJars(String filename) throws Exception {
		return getJars(new File(filename));
	}

	protected static String toPomXml(List<Library> libraries) {
		StringBuilder sb = new StringBuilder();

		_addHeader(sb);

		for (Library library : libraries) {
			_addDependency(
				sb, library.getGroup(), library.getArtifact(),
				library.getVersion());
		}

		_addFooter(sb);

		return sb.toString();
	}

	private static void _addDependency(
		StringBuilder sb, String group, String artifact, String version) {

		sb.append("\t\t<dependency>\n");
		sb.append("\t\t\t<groupId>");
		sb.append(group);
		sb.append("</groupId>\n");
		sb.append("\t\t\t<artifactId>");
		sb.append(artifact);
		sb.append("</artifactId>\n");
		sb.append("\t\t\t<version>");
		sb.append(version);
		sb.append("</version>\n");
		sb.append("\t\t</dependency>\n");
	}

	private static void _addFooter(StringBuilder sb) {
		sb.append("\t</dependencies>\n");
		sb.append("</project>");
	}

	private static void _addHeader(StringBuilder sb) {
		sb.append("<?xml version=\"1.0\"?>\n\n");
		sb.append("<project\n");
		sb.append("\txmlns=\"http://maven.apache.org/POM/4.0.0\"\n");
		sb.append(
			"\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
		sb.append(
			"\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 " +
				"http://maven.apache.org/xsd/maven-4.0.0.xsd\"\n");
		sb.append(">\n");
		sb.append("\t<groupId>com.liferay</groupId>\n");
		sb.append("\t<artifactId>dxp.7.1.x</artifactId>\n");
		sb.append("\t<version>0.0.1</version>\n");
		sb.append("\t<dependencies>\n");
	}

	private static String _LIB_PORTAL_PATH = "lib/portal/";
}