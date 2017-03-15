package com.oracle.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import COM.FutureTense.Interfaces.Utilities;

import com.fatwire.transformer.common.DocumentTransformer;
import com.fatwire.transformer.common.TransformerFactory;
import com.fatwire.transformer.common.TransformerFormat;

/**
 * This is a standalone test class to check the transformer is working ok.
 * 
 * @author phil.gleghorn@oracle.com
 *
 */
public class Main {

	public static Log _logger = LogFactory.getLog(Main.class
			.getName());

	private void doWork(String filename) {
		DocumentTransformer _transformer = TransformerFactory.getTransformer(
				null, "txt");
		_logger.info("Trying to read " + filename
				+ ". using document transformer");
		_logger.info("Using transformer "
				+ _transformer.getClass().getName());
		if (null != _transformer && Utilities.fileExists(filename)) {
			TransformerFormat outputformat = new TransformerFormat("Test",
					"plain/text", "txt");
			String outfile = null;
			try {
				outfile = _transformer
						.getOutputDocument(filename, outputformat);
				_logger.info("Transformer wrote " + outfile);
				String r = Utilities.readFile(outfile);
				_logger.info(r);
			} catch (Throwable e) {
				_logger.fatal("Error met when trying to convert file "
						+ filename + " to text file: " + e.toString());
			}
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		String filename = "/home/phil/Downloads/PruebaIndexacion.pdf";

		if (args.length > 1)
			filename = args[1];
		m.doWork(filename);
	}

}
