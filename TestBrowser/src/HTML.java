import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HTML
{

	private String	fileName	= "Assets/index.html";
	private String	cssFileName	= "Assets/base.css";
	private File			htmlFile;
	private File			cssFile;
	private PrintWriter		writer;

	public HTML()
	{
		htmlFile = new File(fileName);
		cssFile = new File(cssFileName);		
		cssFileName = cssFile.getAbsolutePath();
		fileName = htmlFile.getAbsolutePath();

		
		try
		{
			writer = new PrintWriter(new FileWriter(htmlFile));
			htmlStart();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public String getURL() {
		return fileName;
	}

	public void htmlStart()
	{
		writer.println("<html>");					
		writer.flush();
		htmlCSSLink(cssFileName);
	}

	public void htmlEnd()
	{
		writer.println("</html>");
		writer.flush();
	}

	public void htmlCSSLink(String link)
	{
		writer.println("<head>");
		writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + link + "\">");
		writer.println("</head>");
	}

	public void htmlHeader(String content)
	{
		writer.println("<h>" + content + "</h>");
		writer.flush();
	}

	public void htmlHeader(String content, int id)
	{
		writer.println("<h" + id + ">" + content + "</h" + id + ">");
		writer.flush();
	}

	public void htmlTable(String[] headers, List<String[]> data)
	{
		writer.println("<table>");
		writer.println("	<tr>");
		for (int i = 0; i < headers.length; i++)
		{
			writer.println("	 <th>" + headers[i] + "</th>");
		}
		writer.println("	</tr>");

		for (int i = 0; i < data.size(); i++)
		{
			if (data.get(i).length == headers.length)
			{
				writer.println("	<tr>");
				for (int j = 0; j < data.get(i).length; j++)
				{
					writer.println("	 <td>" + data.get(i)[j] + "</td>");
				}
				writer.println("	</tr>");
			}
		}

		writer.flush();
		writer.println("</table>");
	}

}
