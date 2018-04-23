import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.SWT;

public class Test
{

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			SQLQuery.startjdbc();
			SQLQuery.dbconnect("Manuscript2018", "bisho3ca", "cs474");		
			Test window = new Test();
			window.open();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(963, 560);
		shell.setText("SWT Application");
		HTML main = new HTML();
		Browser browser = new Browser(shell, SWT.NONE);
		browser.setUrl(main.getURL());
		
		browser.setBounds(10, 10, 941, 514);

		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}
}
